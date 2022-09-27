package uz.writer.exeptions;

import io.vavr.collection.Seq;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class BadRequestException extends DomainExceptionWithErrors {

    public BadRequestException(String reason) {
        this(reason, null, null);
    }

    public BadRequestException(String objectName, String reason) {
        this(reason, null, null);
    }

    public BadRequestException(String reason, String objectName,
                               Seq<DomainError> errors) {
        super(BAD_REQUEST, reason, objectName, errors);
    }
}
