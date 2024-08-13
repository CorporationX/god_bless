package handle.exceptions;

import lombok.NonNull;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        int param = 400;
        var result = withExceptionHandling(() -> service.call(param), (e) -> e.getMessage().length());
        System.out.println(result);
    }

    public static <T> T withExceptionHandling(@NonNull Supplier<T> supplier, @NonNull ExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return handler.handle(e);
        }
    }
}
