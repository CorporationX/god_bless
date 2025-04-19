package processing.exceptions;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> RemoteService.call("Test");
        ServiceCallable<String> serviceCallable = e -> {
            System.out.println("Ошибка");
            return "DEFAULT"; };
        String result = ErrorProcessor.withErrorHandling(supplier, serviceCallable);

        System.out.println(result);
    }
}
