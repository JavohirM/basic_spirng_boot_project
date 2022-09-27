package uz.writer.auth.manager;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import uz.writer.auth.jwt.JwtUtil;
import uz.writer.exeptions.CustomNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationManagers implements AuthenticationManager {

    private final JwtUtil jwtUtil;

    public AuthenticationManagers(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String authToken = authentication.getCredentials().toString();

        try {
            if (!jwtUtil.validateToken(authToken)) {
                throw new CustomNotFoundException("Token is unvalid");
            }

            Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
            List<String> roleMap = claims.get("role", List.class);
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (String roles : roleMap) {
                authorities.add(new SimpleGrantedAuthority(roles));
            }
            return new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities);
        } catch (Exception e) {
            throw new BadCredentialsException("Error is found from authentication");
        }
    }
}
