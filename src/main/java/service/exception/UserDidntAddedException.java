package service.exception;

/**
 * User:Anton_Iehorov
 * Date: 12/20/2016
 * Time: 11:07 AM
 */
public class UserDidntAddedException extends RuntimeException {
    public UserDidntAddedException() {
    }

    public UserDidntAddedException(String message) {
        super(message);
    }

    public UserDidntAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDidntAddedException(Throwable cause) {
        super(cause);
    }

    public UserDidntAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
