package hu.czirko.SpringBoot_01.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.Date;


@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception e, WebRequest req) {

        ExceptionResponse exRes = new ExceptionResponse(new Date(), e.getMessage(), req.getDescription(false));

        return new ResponseEntity(exRes, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e, WebRequest req) {

        ExceptionResponse exRes = new ExceptionResponse(new Date(), e.getMessage(), req.getDescription(false));

        return new ResponseEntity(exRes, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest req) {
        ExceptionResponse exRes = new ExceptionResponse(new Date(), "Validation Failed", e.getBindingResult().toString());

        return new ResponseEntity(exRes, HttpStatus.BAD_REQUEST);
    }
}
