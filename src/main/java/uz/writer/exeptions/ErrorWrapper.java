package uz.writer.exeptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorWrapper{
    private static final Logger LOG = LoggerFactory.getLogger(ErrorWrapper.class);

    public static Throwable databaseErrorWrapper(Throwable err, String method) {
        LOG.error("Error ({}) : [{}]", method, err.getMessage());
        throw new DatabaseException(ApiErrorMessages.INTERNAL_SERVER_ERROR + err.getMessage());
    }

    private ErrorWrapper() {
    }
}
