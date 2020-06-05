package pl.jaz.jazapp.exceptions;

public class UserDoesNotExistException extends Exception {
    public UserDoesNotExistException(Throwable ex) {
        super(ex);
    }
}
