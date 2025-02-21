package errors;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandler {
    private static final Logger logger = Logger.getLogger(ErrorHandler.class.getName());
    private static final String ERROR_MESSAGE = "Error occurred during action execution";
    private static final String ERROR_DETAILS_MESSAGE = "Error occurred: ";
    private static final String DEFAULT_RETURN_VALUE = "DEFAULT";
    private static final String REMOTE_SERVICE_UNAVAILABLE = "Remote service is unavailable";

    public static <T> T withErrorHandling(Supplier<T> mainAction, Function<Exception, T> errorHandler) {
        try {
            return mainAction.get();
        } catch (Exception e) {
            logger.log(Level.SEVERE, ERROR_MESSAGE, e);
            return errorHandler.apply(e);
        }
    }

    public static void main(String[] args) {
        String result = withErrorHandling(
                ErrorHandler::callRemoteService,
                ErrorHandler::handleError
        );
        System.out.println("Result: " + result);
    }

    private static String callRemoteService() {
        throw new RuntimeException(REMOTE_SERVICE_UNAVAILABLE);
    }

    private static String handleError(Exception e) {
        System.out.println(ERROR_DETAILS_MESSAGE + e.getMessage());
        return DEFAULT_RETURN_VALUE;
    }
}
