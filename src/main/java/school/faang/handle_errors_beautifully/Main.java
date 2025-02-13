package school.faang.handle_errors_beautifully;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHanding(
                () -> RemoteService.call("someParam"),
                e -> {
                    logger.error("Error when calling the service, return default value");
                    return "DEFAULT";
                });
        logger.info(result);
        try {
            result = ErrorHandler.withErrorHanding(null, null);
            logger.info(result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }


    }
}
