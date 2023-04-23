package exceptions;

public class NoUserLoggedInException extends Throwable {
    public NoUserLoggedInException(String message) {
        super(message);
    }
}
