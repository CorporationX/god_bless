package school.faang.train_streams;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(32, 3, 4, 65, 12, -10);
        List<String> words = List.of("gui","run", "cupol", "circle", "ytuo", "citrus", "ion", "cerber");
//        int result = MethodsStreams.findingTheOverage(numbers);
        List<String> resultCount = MethodsStreams.sortListByLength(words);
//        System.out.println(result);
        System.out.println(resultCount);
        System.out.println(MethodsStreams.checkingNumbersForValidity(numbers, predicateIntegerValid));
        System.out.println(MethodsStreams.smallestNumberAfterStartingValue(numbers, 10));
        System.out.println(MethodsStreams.stringsToIntegersLengths(words));
    }

    private static Predicate<Integer> predicateIntegerValid = number -> number > 0;
}
