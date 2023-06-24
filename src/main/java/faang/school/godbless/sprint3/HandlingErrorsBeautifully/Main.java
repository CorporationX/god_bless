package faang.school.godbless.sprint3.HandlingErrorsBeautifully;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws Exception {
        Function<Integer, Integer> function = (b) -> b * 2;
        System.out.println(withErrorHandling("False", function, (tmp) -> new Exception()));
    }
    public static Object withErrorHandling(Object tmp, Function function, ExceptionHandler exception) throws Exception{
        try {
            return function.apply(tmp);
        } catch (Exception e){
            System.out.println(e);
            return exception.act("Err");
        }
    }
}
