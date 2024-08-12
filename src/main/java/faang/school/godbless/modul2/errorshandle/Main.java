package faang.school.godbless.modul2.errorshandle;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Successful connection";
        ExceptionHandler<String> exceptionHandler = (e) -> e + " error";

        System.out.println(withErrorHandling(supplier, exceptionHandler));
    }
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandling.handle(e);
        }
    }
}
