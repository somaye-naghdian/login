package ir.dotin.registration.exception;

public class InternalServerErrorException extends RuntimeException{

    public InternalServerErrorException(Exception ex) {
        super("Internal Server Error");
        this.initCause(ex);
    }
}
