package school.faang.lambda.error_handler;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionInterface<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            log.info("{}", e.getMessage());
            return handler.handle(e);
        }
    }
}
