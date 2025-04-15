package school.faang.bjs2_70122;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
            () -> RemoteService.call("someParam"),
            e -> showException("DEFAULT")
        );
        log.info(result);

        result = ErrorHandler.withErrorHandling(
            () -> RemoteService.call("NORMAL"),
            e -> showException("call NORMAL")
        );
        log.info(result);
    }

    private static String showException(String message) {
        String ERROR_MESSAGE = "Error when calling the service, we return the default value: {}";
        log.error(ERROR_MESSAGE, message);
        return message;
    }
}