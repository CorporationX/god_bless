package faang.school.godbless.catchingMistakes;

import java.util.function.Supplier;

public class Main {

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler){
        try {
           return supplier.get();
        } catch (Exception e){
            return handler.handle(e);
        }
    }
}
