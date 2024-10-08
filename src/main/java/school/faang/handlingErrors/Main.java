package school.faang.handlingErrors;

import java.util.function.Function;

public class Main {
    private static final String DEFAULT = "default value";
    public static void main(String[] args) {
        MockService service = new MockService();
        String stringParam = "Some bad param";
        ExceptionHandler<String, String, Exception> stringCaller = service::call;
        Function<Exception, String> stringHandler = exception -> {
            System.out.println("Service is unavailable.");
            return DEFAULT;
        };

        System.out.println(withErrorHandling(stringParam, stringCaller, stringHandler));
    }

    public static <T> T withErrorHandling(
            T param, ExceptionHandler<T, T, Exception> caller, Function<Exception, T> handler) {
        try {
            return caller.apply(param);
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
