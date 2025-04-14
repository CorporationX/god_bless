package school.faang.errors_handling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String resultValue = ErrorHandler.withErrorHandling(() ->
                        ErrorHandler.externalService("calling external method"),
                e -> {
                    log.warn("remote service threw exception with message {}, returning default value", e.getMessage());
                    return "DEFAULT VALUE";
                });
        System.out.println(resultValue);
    }
}
