package school.faang.bjs2_80091;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Supplier<String> action = () -> {
            if (Math.random() > 0.5) {
                RemoteService.call();
            }
            return "Success!";
        };

        ExceptionHandler<String> handler = e -> {
            log.error("Error: " + e.getMessage());
            return "DEFAULT VALUE";
        };

        String result = ErrorHandler.withErrorHandling(action, handler);

        log.info(result);
    }

}
