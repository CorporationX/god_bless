package faang.school.godbless.ErrorHandling;

import java.util.function.Function;

public class Main {
    @SuppressWarnings("unchecked")
    public static <U, V, E extends Exception> V withErrorHandling(Function<U, V> function, U param, ExceptionHandler<E> errorHandling, V defaultValue) {
        try {
            return function.apply(param);
        } catch (Exception e) {
             errorHandling.handle((E) e);
               return defaultValue;
        }
    }


    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = Integer::parseInt;
        ExceptionHandler<Exception> handler = (ex) -> {
            System.out.println(ex.getMessage());
            System.out.println("errorCode");

        };

        Integer result = withErrorHandling(parseIntFunction, "123", handler, -1);
        System.out.println("Result:  " + result);
        Integer BADresult = withErrorHandling(parseIntFunction, "123a", handler, -1);
        System.out.println("Result:  " + BADresult);
    }

}

