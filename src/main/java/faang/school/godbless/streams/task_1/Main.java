package faang.school.godbless.streams.task_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfEvens = Util.sumOfEvenNumbers(numbers);
        System.out.println("Sum of even numbers: " + sumOfEvens);

        int maxNumber = Util.maxOfNumbers(numbers);
        System.out.println("Max number: " + maxNumber);

        double avgNumber = Util.avgOfNumbers(numbers);
        System.out.println("Average of numbers: " + avgNumber);

        List<String> strings = List.of("apple", "banana", "apricot", "blueberry", "avocado");
        char startingChar = 'a';
        long countStartingWithA = Util.countStringsStartingWith(strings, startingChar);
        System.out.println("Count of strings starting with '" + startingChar + "': " + countStartingWithA);

        String substring = "ap";
        List<String> filteredStrings = Util.filterStringContainingSubstring(strings, substring);
        System.out.println("Strings containing substring '" + substring + "': " + filteredStrings);

        List<String> sortedStrings = Util.sortStringByLength(strings);
        System.out.println("Sorted strings by length: " + sortedStrings);

        boolean allNumbersGreaterThanZero = Util.checkIfAllMatchCondition(numbers, num -> num > 0);
        System.out.println("All numbers greater than zero: " + allNumbersGreaterThanZero);

        int threshold = 5;
        int minGreaterThanThreshold = Util.findMinGreaterThan(numbers, threshold);
        System.out.println("Minimum number greater than " + threshold + ": " + minGreaterThanThreshold);

        List<Integer> lengthsOfStrings = Util.mapToLengthsOfStrings(strings);
        System.out.println("Lengths of strings: " + lengthsOfStrings);
    }
}
