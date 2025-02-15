package BJS257630;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    protected static String remoteMessage = "Remote service was called";

    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call(remoteMessage),
                e -> {
                    log.info(ExceptionHandler.problemMessage);
                    return "Default";
                }
        );
        log.info(result);
    }

    public static class RemoteService {

        protected static String exceptionMessage = " Runtime Exception ";

        public static String call(String param) {
            log.info(param);
            throw new RuntimeException(exceptionMessage);
        }
    }
}
