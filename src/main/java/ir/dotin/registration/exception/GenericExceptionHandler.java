package ir.dotin.registration.exception;

import ir.dotin.registration.controller.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;
import java.util.UUID;

/**
 * <b>NB!</b> No business logic expected here!
 * Only business logic agnostic exception can be handled here!
 *
 * @see
 */
@Slf4j
@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpException.class)
    ResponseEntity<Object> handleHttpExceptionException(
            final HttpException exception,
            final WebRequest request
    ) {
        final UUID errorId = UUID.randomUUID();
        log.warn("Error #{}. Authorization error: {}", errorId, exception.getMessage(), exception);

        ErrorResponse errorResponse = ErrorResponse.builder().error(true).code(exception.getStatus())
                .message(exception.getMessage()).build();
        HttpStatus httpStatus = HttpStatus.resolve(exception.getStatus());
        Objects.requireNonNull(httpStatus);
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), httpStatus, request);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    ResponseEntity<Object> handleDuplicateKeyException(
            final SQLIntegrityConstraintViolationException exception,
            final WebRequest request
    ) {
        final UUID errorId = UUID.randomUUID();
        log.warn("Error #{}. Authorization error: {}", errorId, exception.getMessage(), exception);

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = ErrorResponse.builder().error(true).code(httpStatus.value())
                .message("duplicate key or wrong value for relations ...").build();

        Objects.requireNonNull(httpStatus);
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), httpStatus, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final UUID errorId = UUID.randomUUID();
        log.warn("Error #{}. Authorization error: {}", errorId, ex.getMessage(), ex);

        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }


}
