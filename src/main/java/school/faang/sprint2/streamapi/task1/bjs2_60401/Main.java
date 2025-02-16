package school.faang.sprint2.streamapi.task1.bjs2_60401;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20, 15, 3, -2, 8, 12);
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "mango");
        Predicate<Integer> isPositive = num -> num > 0;

        System.out.printf("\nMax number: %d", StreamApi.findMaxNumber(numbers));
        System.out.printf("\nAverage: %.3f", StreamApi.findAverage(numbers));
        System.out.printf("\nNumber of strings starting with 'b': %d",
                StreamApi.findNumberOfStringsStartWith(words, 'b'));
        System.out.printf("\nWords containing 'an': %s", StreamApi.filterStringContainSubstring(words, "an"));
        System.out.printf("\nSorted by length: %s", StreamApi.sortByStringLength(words));
        System.out.printf("\nAre all numbers positive? | %s", StreamApi.checkCondition(numbers, isPositive));
        System.out.printf("\nMin number greater than 10: %d", StreamApi.findMinAboveThreshold(numbers, 10));
        System.out.printf("\nLengths of words: %s", StreamApi.convertStringToLengths(words));
    }
}
