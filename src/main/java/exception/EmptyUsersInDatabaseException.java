package exception;

/**
 * User:Anton_Iehorov
 * Date: 12/19/2016
 * Time: 2:20 PM
 */
public class EmptyUsersInDatabaseException extends RuntimeException {
    public EmptyUsersInDatabaseException(String message) {
        super(message);
    }
}
