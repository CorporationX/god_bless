package faang.school.godbless.letspracticestreamapi1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 10, 15, 20, 25);

        List<String> strings = Arrays.asList("apple", "banana", "apricot", "cherry", "grape", "melon", "mango");

        int sumEven = ListUtils.sumOfEvenNumbers(numbers);
        System.out.println("Sum of even numbers: " + sumEven);

        int maxNumber = ListUtils.findMax(numbers);
        System.out.println("Max number: " + maxNumber);

        double average = ListUtils.findAverage(numbers);
        System.out.println("Average: " + average);

        long count = ListUtils.countStringsStartingWith(strings, 'a');
        System.out.println("Strings starting with 'a': " + count);

        List<String> filteredStrings = ListUtils.filterStringsContainingSubstring(strings, "ap");
        System.out.println("Strings containing 'ap': " + filteredStrings);

        List<String> sortedByLength = ListUtils.sortStringsByLength(strings);
        System.out.println("Strings sorted by length: " + sortedByLength);

        boolean allGreaterThan10 = ListUtils.allMatchCondition(numbers, 10);
        System.out.println("All elements greater than 10: " + allGreaterThan10);

        int minGreaterThan10 = ListUtils.findMinGreaterThan(numbers, 10);
        System.out.println("Smallest number greater than 10: " + minGreaterThan10);

        List<Integer> stringLengths = ListUtils.transformStringsToLengths(strings);
        System.out.println("Lengths of strings: " + stringLengths);
    }
}