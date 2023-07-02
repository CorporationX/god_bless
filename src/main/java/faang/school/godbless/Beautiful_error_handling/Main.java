package faang.school.godbless.Beautiful_error_handling;

import java.util.function.Supplier;
import static faang.school.godbless.Beautiful_error_handling.ErrorHandler.withErrorHandling;

public class Main {
    public static void main(String[] args) {
        ExceptionHandler<String> handler1 = e -> "Connection failed";
        Supplier<String> supplier1 = () -> "Connection installed";
        System.out.println(withErrorHandling(supplier1, handler1));
    }
}
