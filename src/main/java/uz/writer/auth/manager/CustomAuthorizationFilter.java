package uz.writer.auth.manager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    private final AuthenticationManagers managers;

    public CustomAuthorizationFilter(AuthenticationManagers managers) {
        this.managers = managers;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/login") || request.getServletPath().equals("/sign-up")) {
            filterChain.doFilter(request, response);
        } else {
            String auth = request.getHeader(AUTHORIZATION);
            if (auth != null && auth.startsWith("Bearer ")) {
                String authToken = auth.substring(7);
                Authentication s = new UsernamePasswordAuthenticationToken(authToken, authToken);
                Authentication authenticate = this.managers.authenticate(s);
                SecurityContextHolder.getContext().setAuthentication(authenticate);
                filterChain.doFilter(request, response);
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
