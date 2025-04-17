package school.faang.sprint_2.processing_exceptions;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> RemoteService.call("Test");
        ErrorFallback<String> errorFallback = e -> {
            System.out.println("Ошибка");
            return "DEFAULT"; };
        String result = ErrorProcessor.withErrorHandling(supplier, errorFallback);

        System.out.println(result);
    }
}
