package uz.writer.exeptions;

import io.vavr.collection.Seq;

import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

public class ServiceUnavailableException extends DomainExceptionWithErrors{

    public ServiceUnavailableException(String reason) {
        this(reason, null, null);
    }

    public ServiceUnavailableException(String objectName, String reason) {
        this(reason, null, null);
    }

    public ServiceUnavailableException(String reason, String objectName,
                                       Seq<DomainError> errors) {
        super(SERVICE_UNAVAILABLE, reason, objectName, errors);
    }
}
