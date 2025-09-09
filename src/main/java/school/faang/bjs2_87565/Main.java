package school.faang.bjs2_87565;

import ch.qos.logback.core.net.SocketConnector;

import java.util.Objects;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(() -> Service.message("mes"), e -> {
            System.out.println("ERROR!!!!!!!!!!!!!!!!");
            return "you passed null";
        });
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
        return (T) "Ready";
    }
}

