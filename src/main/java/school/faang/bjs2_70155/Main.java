package school.faang.bjs2_70155;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String resultFail = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    getError();
                    return "DEFAULT";
                }
        );

        log.info(resultFail);

        String resultSuccess = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("https://"),
                e -> {
                    getError();
                    return "DEFAULT";
                }
        );

        log.info(resultSuccess);
    }

    private static void getError() {
        log.error("Error calling service, returning default value");
    }
}