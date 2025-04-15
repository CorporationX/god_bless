package school.faang.errorhandling.main;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {

    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> new RemoteService().getData(),
                e -> {
                    log.warn("Error: " + e.getMessage());
                    return "Service data";
                }
        );
        System.out.println("Result: " + result);

    }

    public static <T> T withErrorHandling(Supplier<T> action, ErrorHandler<T> handle) {
        try {
            return action.get();
        } catch (Exception e) {
            return handle.handler(e);
        }
    }
}