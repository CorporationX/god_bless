package faang.school.godbless.sprint2.stream.streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Runner {

    public static void main(String[] args) {
        int valueForGreaterThan = 7;
        int minValue = 3;
        char firstLetter = 'f';
        String substring = "ve";

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        System.out.println("Given list of numbers: " + numbers);
        System.out.println("Given list of strings: " + strings);

        System.out.println("Sum of even numbers: " + StreamUtilOperations.getSumOfEvenNumbers(numbers));

        Optional<Integer> max = StreamUtilOperations.findMax(numbers);
        max.ifPresent(m -> System.out.println("Maximum number: " + m));

        double average = StreamUtilOperations.findAverage(numbers);
        System.out.println("Average of numbers: " + average);

        long count = StreamUtilOperations.countStringsStartingWithChar(strings, firstLetter);
        System.out.println("Number of strings starting with + '" + firstLetter + "': " + count);

        List<String> filteredStrings = StreamUtilOperations.filterStringContainingSubstring(strings, substring);
        System.out.println("Strings containing '" + substring + "': " + filteredStrings);

        List<String> sortedStrings = StreamUtilOperations.sortStringsByLength(strings);
        System.out.println("Strings sorted by length: " + sortedStrings);

        boolean allGreaterThanSeven = StreamUtilOperations.areAllNumbersGreaterThanValue(numbers, valueForGreaterThan);
        System.out.println("Are all numbers greater than " + valueForGreaterThan + "? " + allGreaterThanSeven);

        Optional<Integer> smallestGreaterThanThree = StreamUtilOperations.findSmallestGreaterThanValue(numbers, minValue);
        smallestGreaterThanThree.ifPresent(s -> System.out.println("Smallest number greater than " + minValue + ": " + s));

        List<Integer> lengths = StreamUtilOperations.convertStringsToTheirLengths(strings);
        System.out.println("Lengths of strings: " + lengths);
    }
}
