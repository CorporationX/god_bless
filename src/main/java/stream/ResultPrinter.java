package stream;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


public class ResultPrinter {
    public static <T, W> void printResult(Function<List<T>, W> function, List<T> list) {
        System.out.println(function.apply(list));
    }

    public static <T, R, W> void printResultBiFunction(BiFunction<List<T>, R, W> function, List<T> list, R element) {
        System.out.println(function.apply(list, element));
    }
}