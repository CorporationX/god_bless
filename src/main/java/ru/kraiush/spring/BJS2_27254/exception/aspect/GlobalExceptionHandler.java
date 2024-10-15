package ru.kraiush.spring.BJS2_27254.exception.aspect;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.w3c.dom.events.EventException;
import ru.kraiush.spring.BJS2_27254.domain.dto.ErrorDto;
import ru.kraiush.spring.BJS2_27254.domain.model.ErrorResponse;
import ru.kraiush.spring.BJS2_27254.exception.DataValidationException;
import ru.kraiush.spring.BJS2_27254.exception.ElementAlreadyExistsException;
import ru.kraiush.spring.BJS2_27254.exception.ElementNotFoundException;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final int STACK_TRACE_DEEP = 10;

    @Value("BASE_PACKAGE")
    private String BASE_PACKAGE;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream()
                .collect(Collectors.toMap(
                        error -> ((FieldError) error).getField(),
                        error -> Objects.requireNonNullElse(error.getDefaultMessage(), ""))
                );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataFormatException.class)
    public ErrorResponse handleDataFormatException(DataFormatException ex) {
        log.error("Data format error" + ex);
        return new ErrorResponse("Data format error - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ElementNotFoundException.class)
    public ErrorResponse handleNotFoundException(ElementNotFoundException ex) {
        log.error("Failed to find the requested element" + ex);
        return new ErrorResponse("Failed to find the requested element - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataValidationException.class)
    public ErrorResponse handleDataValidationException(DataValidationException ex) {
        log.error("Data validation error" + ex);
        return new ErrorResponse("Data validation error - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse notFoundEntityException(EntityNotFoundException ex) {
        log.error("Entity not found" + ex);
        return new ErrorResponse(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ErrorResponse handleResourceAlreadyExistsException(ElementAlreadyExistsException ex) {
        log.error("Resource Already Exists" + ex);
        return new ErrorResponse("Resource Already Exists - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse mismatchTypeException(MethodArgumentTypeMismatchException ex) {
        log.error("Mismatch argument type" + ex);
        return new ErrorResponse("Mismatch argument type - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAllUncaughtException(
            Exception ex,
            WebRequest request) {
        log.error("Unknown error occurred", ex);
        return new ErrorResponse("Unknown error occurred - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EventException.class)
    public ResponseEntity<ErrorDto> handleException(final HttpServletRequest request, final Exception ex) {
        val trace = stream(ex.getStackTrace())
                .filter(source -> source.getClassName().startsWith(BASE_PACKAGE))
                .map(StackTraceElement::toString)
                .limit(STACK_TRACE_DEEP)
                .collect(toList());

        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(
                        ErrorDto.init()
                                .setSuccess(false)
                                .setUri(request.getRequestURI())
                                .setCode(INTERNAL_SERVER_ERROR.value())
                                .setTitle(INTERNAL_SERVER_ERROR.getReasonPhrase())
                                .setDescription(ex.getMessage())
                                .setMessage(ex.getCause().toString())
                                .setStackTrace(trace)
                                .build()
                );
    }
}
