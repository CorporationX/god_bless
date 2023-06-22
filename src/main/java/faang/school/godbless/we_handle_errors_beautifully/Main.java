package faang.school.godbless.we_handle_errors_beautifully;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Supplier<String> supplier = Service::getName;
        ExceptionHandler<String> handler = Throwable::toString;

        System.out.println(withErrorHandler(supplier, handler));
    }

    private static <T> T withErrorHandler(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return (T) errorHandler.getServiceException(e);
        }
    }
}
