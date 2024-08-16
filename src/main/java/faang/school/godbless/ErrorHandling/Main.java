package faang.school.godbless.ErrorHandling;

import java.util.function.Function;

public class Main {
    @SuppressWarnings("unchecked")
    public static <U, V, E extends Exception> V withErrorHandling(Function<U, V> function, U param, ExceptionHandler<E, V> errorHandling, V defaultValue) {
        try {
            return function.apply(param);
        } catch (Exception e) {
            return errorHandling.handle((E) e, defaultValue);

        }
    }


    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = Integer::parseInt;
        ExceptionHandler<Exception, Integer> handler = (ex, dfValue) -> {
            System.out.println(ex.getMessage());
            System.out.println("errorCode");
            return dfValue;
        };

        Integer result = withErrorHandling(parseIntFunction, "123", handler, -1);
        System.out.println("Result:  " + result);
        Integer BADresult = withErrorHandling(parseIntFunction, "123a", handler, -1);
        System.out.println("Result:  " + BADresult);
    }

}

