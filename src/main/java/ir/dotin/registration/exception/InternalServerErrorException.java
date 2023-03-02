package ir.dotin.registration.exception;

public class InternalServerErrorException extends HttpException{

    public InternalServerErrorException(Exception ex) {
        super("Internal Server Error", 500);
        this.initCause(ex);
    }
}
