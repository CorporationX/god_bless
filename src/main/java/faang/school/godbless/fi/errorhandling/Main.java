package faang.school.godbless.fi.errorhandling;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        String result = withErrorHandling(Main::callBrokenMethod,
                (exception) -> "> check the value to avoid NullPointerException");

        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (NullPointerException e) {
            return onError.handle(e);
        }
    }

    public static String callBrokenMethod() {
        String nullable = null;
        return nullable.toUpperCase();
    }

}
