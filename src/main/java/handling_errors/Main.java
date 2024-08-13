package handling_errors;
import java.util.function.Supplier;

public class Main {

    static Service service = new Service();

    public static void main(String[] args) {
        String result = withErrorHandling(() -> service.call("123"), Throwable::getMessage);
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }

}
