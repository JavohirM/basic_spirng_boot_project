package uz.writer.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestCustomFilter extends GenericFilterBean {

    private final Logger log = LoggerFactory.getLogger(RestCustomFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest currentRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse currentResponse = (HttpServletResponse) servletResponse;
        StringBuffer requestURL = currentRequest.getRequestURL();
        try {
            filterChain.doFilter(currentRequest, servletResponse);
        } finally {
            int status = currentResponse.getStatus();
            log.info("Request URL: {} | Method: {} | Protocol: {} | PathInfo: {} | Remote Address: {} | Response status: {} ", requestURL, currentRequest.getMethod(), currentRequest.getProtocol(), currentRequest.getPathInfo(),currentRequest.getRemoteAddr(), status);
        }
    }
}

