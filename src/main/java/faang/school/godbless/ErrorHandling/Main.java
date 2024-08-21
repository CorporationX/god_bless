package faang.school.godbless.ErrorHandling;

import java.util.function.Function;

public class Main {
    public static <U, V> V withErrorHandling(Function<U, V> function, U param, ExceptionHandler<V> errorHandling, V defaultValue) {
        try {
            return function.apply(param);
        } catch (Exception e) {
            return errorHandling.handle(defaultValue, e);
        }
    }


    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = Integer::parseInt;
        ExceptionHandler<Integer> handler = (defaultValue, ex) -> {
            System.out.println(ex.getMessage());
            System.out.println("errorCode");
            return defaultValue;
        };

        Integer result = withErrorHandling(parseIntFunction, "123", handler, -1);
        System.out.println("Result:  " + result);
        Integer BADresult = withErrorHandling(parseIntFunction, "123a", handler, -1);
        System.out.println("Result:  " + BADresult);
    }

}

