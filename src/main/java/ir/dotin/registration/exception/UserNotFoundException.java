package ir.dotin.registration.exception;

public class UserNotFoundException extends HttpException {

    public UserNotFoundException() {
        super("user not found", 400);
    }
}
