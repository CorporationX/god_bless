package errors.handling;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();

        String request = withErrorHandling(() -> service.call("123"),
                (e) -> e.getMessage());

        String wrongRequest = withErrorHandling(() -> service.call("321"),
                (e) -> e.getMessage());
        System.out.println(request);
        System.out.println(wrongRequest);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandling.handle(e);
        }
    }

}
