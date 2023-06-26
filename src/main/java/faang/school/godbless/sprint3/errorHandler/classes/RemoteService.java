package faang.school.godbless.sprint3.errorHandler.classes;

import faang.school.godbless.sprint3.errorHandler.interfaces.ExceptionHandler;

import java.util.function.Supplier;

public class RemoteService {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler) {
        if (supplier == null || handler == null) {
            throw new IllegalArgumentException("Supplier or ExceptionHandler is null");
        }
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.handling(e);
        }
    }
}
