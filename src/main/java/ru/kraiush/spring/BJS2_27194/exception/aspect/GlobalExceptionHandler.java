package ru.kraiush.spring.BJS2_27194.exception.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kraiush.spring.BJS2_27194.exception.model.ErrorDto;
import ru.kraiush.spring.BJS2_27194.exception.EventException;

import static java.util.Arrays.stream;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static ru.kraiush.spring.BJS2_27194.common.Constants.Common.BASE_PACKAGE;

@Slf4j
@RequiredArgsConstructor
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final int STACK_TRACE_DEEP = 10;
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EventException.class)
    public ResponseEntity<ErrorDto> handleException(final HttpServletRequest request, final Exception exception) {
        val trace = stream(exception.getStackTrace())
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
                                .setUuid(randomUUID())
                                .setCode(INTERNAL_SERVER_ERROR.value())
                                .setTitle(INTERNAL_SERVER_ERROR.getReasonPhrase())
                                .setDescription(exception.getMessage())
                                .setMessage(exception.getCause().toString())
                                .setStackTrace(trace)
                                .build()
                );
    }
}
