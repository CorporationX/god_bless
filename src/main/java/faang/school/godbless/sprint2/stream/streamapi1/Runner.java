package faang.school.godbless.sprint2.stream.streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Runner {

    public static void main(String[] args) {
        try {
            List<Integer> emptyNumbers = List.of();
            List<String> emptyStrings = List.of();
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

            System.out.printf("Given list of numbers: %s%n", numbers);
            System.out.printf("Given list of strings: %s%n", strings);

            System.out.printf("Sum of even numbers: %d%n",
                    StreamUtilOperations.getSumOfEvenNumbers(numbers));
            System.out.printf("Sum of even numbers in empty list: %d%n",
                    StreamUtilOperations.getSumOfEvenNumbers(emptyNumbers));

            Optional<Integer> max = StreamUtilOperations.findMax(numbers);
            max.ifPresent(m -> System.out.printf("Maximum number: %d%n", m));

            double average = StreamUtilOperations.findAverage(numbers);
            System.out.printf("Average of numbers: %.2f%n", average);

            long count = StreamUtilOperations.countStringsStartingWithChar(strings, Constants.FIRST_LETTER);
            System.out.println("Number of strings starting with + '" + Constants.FIRST_LETTER + "': " + count);

            List<String> filteredStrings = StreamUtilOperations
                    .filterStringContainingSubstring(strings, Constants.SUBSTRING);
            System.out.printf("Strings containing '%s': %s%n", Constants.SUBSTRING, filteredStrings);
            List<String> filteredStringsInEmptyList = StreamUtilOperations
                    .filterStringContainingSubstring(emptyStrings, Constants.SUBSTRING);
            System.out.printf("Strings containing '%s' in empty list: %s%n", Constants.SUBSTRING, filteredStringsInEmptyList);

            List<String> sortedStrings = StreamUtilOperations.sortStringsByLength(strings);
            System.out.printf("Strings sorted by length: %s%n", sortedStrings);
            List<String> sortedStringsInEmptyList = StreamUtilOperations.sortStringsByLength(emptyStrings);
            System.out.printf("Strings sorted by length in empty list: %s%n", sortedStringsInEmptyList);

            boolean allGreaterThanSeven = StreamUtilOperations
                    .areAllNumbersGreaterThanValue(numbers, Constants.VALUE_FOR_GREATER_THAN);
            System.out.printf("Are all numbers greater than %d? %b%n",
                    Constants.VALUE_FOR_GREATER_THAN, allGreaterThanSeven);

            Optional<Integer> smallestGreaterThanThree = StreamUtilOperations
                    .findSmallestGreaterThanValue(numbers, Constants.MIN_VALUE);
            smallestGreaterThanThree.ifPresent(val -> {
                System.out.printf("Smallest number greater than %d: %d%n", Constants.MIN_VALUE, val);
            });

            List<Integer> lengths = StreamUtilOperations.convertStringsToTheirLengths(strings);
            System.out.printf("Lengths of strings: %s%n", lengths);
            List<Integer> lengthsInEmptyList = StreamUtilOperations.convertStringsToTheirLengths(emptyStrings);
            System.out.printf("Lengths of strings in empty list: %s%n", lengthsInEmptyList);
        } catch (IllegalArgumentException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
