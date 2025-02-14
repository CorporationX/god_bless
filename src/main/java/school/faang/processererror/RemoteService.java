package school.faang.processererror;

import java.util.function.Function;
import java.util.function.Supplier;

public class RemoteService {
    public static String call(String param) {
        throw new RuntimeException("Сервис недоступен");
    }

    public static <T> T withErrorHandling(Supplier<T> runServer, Function<Exception, T> errorHandling) {
        try {
            return runServer.get();
        } catch (Exception e) {
            return errorHandling.apply(e);
        }
    }
}
