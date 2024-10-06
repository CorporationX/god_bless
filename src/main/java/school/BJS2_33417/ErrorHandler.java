package school.BJS2_33417;

import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling (InterfaceWithException<T> supplier, Function<Exception,T> consumer){
        try {
            return supplier.get();
        } catch (Exception e) {
          return consumer.apply(e);
        }
    }
}
