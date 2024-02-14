package faang.school.godbless.HandlingErrorsBeautifully2590;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> useGoodMethod = () -> testGoodMethod();
        Supplier<String> useBrokenMethod = () -> testBrokenMethod();
        ExceptionHandler<String> getMessage = exception -> exception.getMessage();
        System.out.println(withErrorHandling(useGoodMethod, getMessage));
        System.out.println(withErrorHandling(useBrokenMethod, getMessage));
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception exception) {
            return onError.handle(exception);
        }
    }

    public static String testGoodMethod() {
        return "All good dawg";
    }

    public static String testBrokenMethod() {
        throw new NoSuchElementException("No good dawg");
    }
}
