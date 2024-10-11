package ru.kraiush.spring.BJS2_27254.exception.aspect;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.w3c.dom.events.EventException;
import ru.kraiush.spring.BJS2_27254.domain.dto.ErrorDto;
import ru.kraiush.spring.BJS2_27254.domain.model.ErrorMessage;
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
import static ru.kraiush.spring.BJS2_27254.common.Constants.Common.BASE_PACKAGE;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final int STACK_TRACE_DEEP = 10;

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
    public ErrorMessage handleDataFormatException(DataFormatException ex) {
        return new ErrorMessage("Data format error - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ElementNotFoundException.class)
    public ErrorMessage handleNotFoundException(ElementNotFoundException ex) {
        return new ErrorMessage("The resource cannot be found - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataValidationException.class)
    public ErrorMessage handleDataValidationException(DataValidationException ex) {
        return new ErrorMessage("Data validation error - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ErrorMessage notFoundDaoException(ChangeSetPersister.NotFoundException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage notFoundEntityException(EntityNotFoundException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public Object handleAccessDeniedException(
            Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return new ErrorMessage("Access denied - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ErrorMessage handleResourceAlreadyExistsException(ElementAlreadyExistsException ex) {
        return new ErrorMessage("Resource Already Exists - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorMessage mismatchTypeException(MethodArgumentTypeMismatchException ex) {
        return new ErrorMessage("Mismatch argument type - " + ex.getMessage());
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
