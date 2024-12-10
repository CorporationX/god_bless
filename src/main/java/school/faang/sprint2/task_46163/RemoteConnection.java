package school.faang.sprint2.task_46163;

import java.util.function.Function;

public class RemoteConnection {

    public static <T> T withErrorHandling(RemoteConnector<T> action, Function<Exception, T> errorHandler) {
        try {
            return action.connect();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
