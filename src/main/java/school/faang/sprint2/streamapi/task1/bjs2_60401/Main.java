package school.faang.sprint2.streamapi.task1.bjs2_60401;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20, 15, 3, -2, 8, 12);
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "mango");
        Predicate<Integer> isPositive = num -> num > 0;

        System.out.println("Sum of even numbers: " + new StreamApi().findEvenNumbersSum(numbers));
        System.out.println("Max number: " + StreamApi.findMaxNumber(numbers));
        System.out.println("Average: " + StreamApi.findAverage(numbers));
        System.out.println("Number of strings starting with 'b': " + StreamApi.findNumberOfStringsStartWith(words, 'b'));
        System.out.println("Words containing 'an': " + StreamApi.filterStringContainSubstring(words, "an"));
        System.out.println("Sorted by length: " + StreamApi.sortByStringLength(words));
        System.out.println("Are all numbers positive? " + StreamApi.checkCondition(numbers, isPositive));
        System.out.println("Min number greater than 10: " + StreamApi.findMinAboveThreshold(numbers, 10));
        System.out.println("Lengths of words: " + StreamApi.convertStringToLengths(words));
    }
}
