package school.faang.bjs2_80152;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                Application::callRemoteService,
                e -> "default value"
        );
        log.info(result);
    }

    private static String callRemoteService() {
        throw new RuntimeException("Service unavailable");
    }
}
