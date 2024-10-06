package school.BJS2_33417;

import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling (InterfaceWithException<T> iwx, Function<Exception,T> function){
        try {
            return iwx.get();
        } catch (Exception e) {
          return function.apply(e);
        }
    }
}
