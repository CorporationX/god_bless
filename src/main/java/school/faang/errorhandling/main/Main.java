package school.faang.errorhandling.main;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> new RemoteService().getData(),
                e -> {
                    log.warn("Error: " + e.getMessage());
                    return "Service data";
                }
        );
        System.out.println("Result: " + result);

    }
}