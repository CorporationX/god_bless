package faang.school.godbless.BJS2_21099;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    private static String nullString;
    public static void main(String[] args) {
        String result = withErrorHandling(() -> callBrokenMethod(),
                (exception) -> "You must check the value to avoid NullPointerException");

        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError){
        try {
            return action.get();
        } catch (NullPointerException e){
            return onError.handle(e);
        }
    }

    public  static  String callBrokenMethod(){
        String nullable = null;
        return nullable.toUpperCase();
    }
}
