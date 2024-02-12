package faang.school.godbless.exceptionhandle;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        System.out.println("Positive: ");
        Integer pos = withErrorHandling(Main::positiveMock, exception -> {
            System.out.println("Error");
            return 0;
        });
        System.out.println("Value = " + pos);
        System.out.println();
        System.out.println("Negative: ");
        Integer neg = withErrorHandling(Main::negativeMock, exception -> {
            System.out.println("Error: " + exception.getClass().getName());
            return 0;
        });
        System.out.println("Value = " + neg);
    }

    public static int positiveMock() {
        return 5;
    }

    public static int negativeMock() {
        throw new NoSuchElementException("Error");
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
