package ir.dotin.registration.exception;

public abstract class HttpException extends RuntimeException {

    protected final int status;

    protected HttpException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
