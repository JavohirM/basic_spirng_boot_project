package uz.writer.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import uz.writer.config.data.JwtConfigData;
import uz.writer.dao.model.Users;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final JwtConfigData jwtConfigData;
    private Key key;

    public JwtUtil(JwtConfigData jwtConfigData) {
        this.jwtConfigData = jwtConfigData;
    }

    @PostConstruct
    public void init() { this.key = Keys.hmacShaKeyFor(jwtConfigData.getJjwt().getSecret().getBytes());
    }

    public Claims getAllClaimsFromToken(String token){ return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String getUsernameFromToken(String token) { return getAllClaimsFromToken(token).getSubject();}

    public Date getExpirationDateFromToken(String token) {return getAllClaimsFromToken(token).getExpiration();}

    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Users users) {
        Map<String, Object>  claims = new HashMap<>();
        claims.put("role", users.getRoles());
        return doGenerateToken(claims, users.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String username){
        long expirationTimeLong = jwtConfigData.getJjwt().getExpiration();
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();

    }


    public Boolean validateToken(String token) { return !isTokenExpired(token);}
}
