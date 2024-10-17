package ru.kraiush.spring.BJS2_27254.exception.aspect;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.w3c.dom.events.EventException;
import ru.kraiush.spring.BJS2_27254.domain.dto.ErrorDto;
import ru.kraiush.spring.BJS2_27254.domain.model.ErrorResponse;
import ru.kraiush.spring.BJS2_27254.exception.DataValidationException;
import ru.kraiush.spring.BJS2_27254.exception.EmailAlreadyExistsException;
import ru.kraiush.spring.BJS2_27254.exception.ResourceAlreadyExistsException;
import ru.kraiush.spring.BJS2_27254.exception.ResourceNotFoundException;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final int STACK_TRACE_DEEP = 10;

    @Value("BASE_PACKAGE")
    private String BASE_PACKAGE;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        log.error("Method Argument Not Valid" + ex);
        Map<String, String> errors = new HashMap<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

        errorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataFormatException.class)
    public ErrorResponse handleDataFormatException(DataFormatException ex) {
        log.error("Data format error" + ex);
        return new ErrorResponse("DATA FORMAT ERROR - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex,
                                                         WebRequest webRequest) {
        log.error("Failed to find the requested resourse" + ex);
        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "RESOURSE NOT FOUND"
        );
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ErrorResponse handleEmailAlreadyExistsException(EmailAlreadyExistsException ex,
                                                           WebRequest webRequest) {

        log.error("Such email already exist" + ex);
        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "USER EMAIL ALREADY EXISTS"
        );
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ErrorResponse handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex,
                                                              WebRequest webRequest) {
        log.error("Resource Already Exists" + ex);
        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "RESOURSE ALREADY EXISTS"
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataValidationException.class)
    public ErrorResponse handleDataValidationException(DataValidationException ex) {
        log.error("Data validation error" + ex);
        return new ErrorResponse("DATA VALIDATION ERROR - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse notFoundEntityException(EntityNotFoundException ex) {
        log.error("Entity not found" + ex);
        return new ErrorResponse("ENTITY NOT FOUND - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public Object handleAccessDeniedException(
            Exception ex, WebRequest request) {
        log.error("Access denied" + ex);
        return new ErrorResponse("ACCESS DENIED - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse mismatchTypeException(MethodArgumentTypeMismatchException ex) {
        log.error("Mismatch argument type" + ex);
        return new ErrorResponse("MISMATCH ARGUMENT EXCEPTION TYPE - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex,
                                                               WebRequest webRequest) {

        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL SERVER ERROR"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
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
