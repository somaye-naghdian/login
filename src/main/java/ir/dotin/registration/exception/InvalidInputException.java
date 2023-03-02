package ir.dotin.registration.exception;

public class InvalidInputException extends HttpException{

    public InvalidInputException() {
        super("invalid input" , 400);
    }
}
