package faang.school.godbless.exception;

import java.util.function.Supplier;

public class Main {

    public static<T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling){
        try {
            return supplier.get();
        } catch (Exception e){
            return errorHandling.handle(e);
        }
    }

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Success";

        Supplier<String> supplierWithException = () -> {
            throw new RuntimeException("We have an exception!");
        };

        var result1 = withErrorHandling(supplier, Throwable::getMessage);
        System.out.println(result1);

        var resultWithException = withErrorHandling(supplierWithException, e -> "Error: " + e.getMessage());
        System.out.println(resultWithException);
    }
}