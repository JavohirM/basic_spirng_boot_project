package uz.writer.exeptions;

import io.vavr.collection.Seq;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class DatabaseException extends DomainExceptionWithErrors{
    public DatabaseException(String reason) {
        this(reason, null, null);
    }

    public DatabaseException(String objectName, String reason) {
        this(reason, null, null);
    }

    public DatabaseException(String reason, String objectName,
                             Seq<DomainError> errors) {
        super(INTERNAL_SERVER_ERROR, reason, objectName, errors);
    }
}
