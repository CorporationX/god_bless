package faang.school.godbless.BJS2_5330;

import java.util.function.Consumer;

public class ExceptionFromRemoteServer {
    public static <T, E extends Exception> Consumer<T> withErrorHandling(
            ExceptionHandler<T, E> errorHandling, Class<E> exceptionClass) {
       return i -> {
           try{
               errorHandling.accept(i);
           } catch (Exception ex) {
               try {
                   E exCast = exceptionClass.cast(ex);
                   System.err.println("Произошло исключение: " + exCast.getMessage());
               } catch (ClassCastException ccEx) {
                   throw new RuntimeException(ex);
               }
           }
       };
    }
}
