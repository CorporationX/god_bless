package faang.school.godbless.handling.errors;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Handler {
    static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exception) {
        try {
            return supplier.get();
        }
        catch (Exception e){
          return exception.handle(e);
        }
    }
}
