package school.faang.streamapione;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println(
                "Even numbers sum " + StreamUtils.calculateEvenNumbersSum(numbers)
        );
        System.out.println(
                "Max: " + StreamUtils.findMaxNumber(numbers)
        );
        System.out.println(
                "Average: " + StreamUtils.calculateAverageValue(numbers)
        );
        System.out.println(
                "Number of strings starting with 'a': " + StreamUtils.countStringsStartingWith(strings, 'a')
        );
        System.out.println(
                "Strings containing 'an': " + StreamUtils.filterStringsContainingSubstring(strings, "an")
        );
        System.out.println(
                "Sorted by string length: " + StreamUtils.sortStringsByLength(strings)
        );
        System.out.println(
                "Are all numbers even? " + StreamUtils.checkNumbers(numbers, n -> n % 2 == 0)
        );
        System.out.println(
                "The smallest number greater than 4: " + StreamUtils.findMinGreaterThan(numbers, 4)
        );
        System.out.println(
                "String lengths: " + StreamUtils.convertStringsToLengths(strings)
        );
    }
}
