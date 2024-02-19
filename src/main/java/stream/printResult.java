package stream;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class printResult {
    public static <T> void printResult(Function<List<T>, ?> function, List<T> list) {
        System.out.println(function.apply(list));
    }

    public static <T> void printResultBiFunction(BiFunction<List<T>, T, ?> function, List<T> list, T substring) {
        System.out.println(function.apply(list, substring));
    }

    public static <T> void printResultBiFunctionPredicate(BiFunction<List<T>, Predicate<String>, ?> function, List<T> list, Predicate<String> predicate) {
        System.out.println(function.apply(list, predicate));
    }
}