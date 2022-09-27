package uz.writer.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.writer.auth.manager.CustomAuthorizationFilter;
import uz.writer.exeptions.ApiErrorMessages;
import uz.writer.exeptions.CustomUnauthorizedException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomAuthorizationFilter filter;


    public SecurityConfig(CustomAuthorizationFilter filter) {
        this.filter = filter;
    }


 /*   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .authenticationEntryPoint(new CustomUnauthorizedException(ApiErrorMessages.UNAUTHORIZED))
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .antMatchers("/login", "/sign-up", "/users", "/port_ld_10/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .build();

    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(new CustomUnauthorizedException(ApiErrorMessages.UNAUTHORIZED))
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //using JWT
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/sign-up", "/users", "/port_ld_10/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
