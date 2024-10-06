package school.BJS2_33417;

import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling (InterfaceWithException<T> methodCanThrowException, Function<Exception,T> function){
        try {
            return methodCanThrowException.get();
        } catch (Exception e) {
          return function.apply(e);
        }
    }
}
