package faang.school.godbless;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumEven = ListUtils.sumEvenNumbers(numbers);
        System.out.println("Sum of even numbers: " + sumEven);

        int max = ListUtils.findMax(numbers);
        System.out.println("Max number: " + max);

        double average = ListUtils.findAverage(numbers);
        System.out.println("Average: " + average);

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "cherry", "apricot");
        long countA = ListUtils.countStringsStartingWith(strings, 'a');
        System.out.println("Count of strings starting with 'a': " + countA);

        List<String> filteredStrings = ListUtils.filterStringsContaining(strings, "an");
        System.out.println("Strings containing 'an': " + filteredStrings);

        List<String> sortedStrings = ListUtils.sortStringsByLength(strings);
        System.out.println("Strings sorted by length: " + sortedStrings);

        boolean allPositive = ListUtils.allMatch(numbers, n -> n > 0);
        System.out.println("All numbers are positive: " + allPositive);

        int minGreaterThan3 = ListUtils.findMinGreaterThan(numbers, 3);
        System.out.println("Min number greater than 3: " + minGreaterThan3);

        List<Integer> lengths = ListUtils.convertStringsToLengths(strings);
        System.out.println("Lengths of strings: " + lengths);
    }
}