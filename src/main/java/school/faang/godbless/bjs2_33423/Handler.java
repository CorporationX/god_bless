package school.faang.godbless.bjs2_33423;

import java.util.function.Function;
import java.util.function.Supplier;

public class Handler {
    public static <T> T withErrorHandling(FromRemote<T> supplier, Function<Exception, T> handler) {
        try {
            return supplier.getFromRemote();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
