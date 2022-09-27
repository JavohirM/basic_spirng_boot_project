package uz.writer.exeptions;

import com.google.gson.Gson;
import io.vavr.collection.Seq;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import reactor.core.publisher.Mono;
import uz.writer.dao.dto.ResultDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class CustomUnauthorizedException extends DomainExceptionWithErrors implements AuthenticationEntryPoint {

    public CustomUnauthorizedException(String reason) {
        this(reason, null, null);
    }

    public CustomUnauthorizedException(String objectName, String reason) {
        this(reason, null, null);
    }

    public CustomUnauthorizedException(String reason, String objectName,
                                       Seq<DomainError> errors) {
        super(UNAUTHORIZED, reason, objectName, errors);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }
}
