package faang.school.godbless.functionalInterfaces.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String defaultResponse = "DEFAULT";

        Supplier<String> regularAction = () -> {
            log.info("Regular action was successfully completed");
            return "Not default result";
        };
        Supplier<String> brokenAction = () -> {
            throw new NoSuchElementException("Map doesn't have such key!");
        };

        Function<Exception, String> errorCatchingAction = exception -> {
            log.error("Regular action produced exception: " + exception.getMessage());
            return defaultResponse;
        };

        log.info("Executing regular action without exception.");
        var regularActionResult = ErrorHandlingService.withErrorHandling(regularAction, errorCatchingAction);
        log.info("Regular action result: " + regularActionResult);

        log.info("Executing broken regular action.");
        var regularActionWithExceptionResult = ErrorHandlingService.withErrorHandling(brokenAction, errorCatchingAction);
        log.info("Broken regular action result: " + regularActionWithExceptionResult);

        ErrorHandlingService.withErrorHandling(() -> ErrorHandlingService.withErrorHandling(null, errorCatchingAction), errorCatchingAction);
    }
}
