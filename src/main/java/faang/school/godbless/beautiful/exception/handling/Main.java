package faang.school.godbless.beautiful.exception.handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        RemoteService remoteService = new RemoteService();

        String result = ExceptionHandler.withErrorHandling(
                () -> remoteService.call("error"),
                e -> {
                    log.warn("Failed to access Remote Service. Return default value");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}
