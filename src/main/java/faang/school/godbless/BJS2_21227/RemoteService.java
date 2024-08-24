package faang.school.godbless.BJS2_21227;

import java.util.Optional;
import java.util.function.Supplier;

public class RemoteService {
    public <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            exceptionHandler.handling(e);
        }
        return null;
    }
}
