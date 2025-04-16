package processing.exceptions;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier supplier = () -> RemoteService.call("Test");
        ServiceCallException serviceCallException = e -> {
            System.out.println("Ошибка");
            return "DEFAULT"; };
        String result = ErrorProcessor.withErrorHandling(supplier, serviceCallException);

        System.out.println(result);
    }
}
