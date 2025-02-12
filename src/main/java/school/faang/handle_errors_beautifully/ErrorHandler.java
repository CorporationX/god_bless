package school.faang.handle_errors_beautifully;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    public static <T> T withErrorHanding(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }

    private <T> void checkValidArgument(T argument, String argumentName) {
        if (argument == null) {
            logger.error("The argument {} cannot be null! Location {} : {}", argumentName,
                    Thread.currentThread().getStackTrace()[2].getFileName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
}
