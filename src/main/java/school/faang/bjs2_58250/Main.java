package school.faang.bjs2_58250;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.printf("Sum of even numbers: %d%n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Maximum: %d%n", ListOperations.findMax(numbers));
        System.out.printf("Average: %.2f%n", ListOperations.findAverage(numbers));
        System.out.printf("Number of 'a'-starting lines: %d%n", ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Contains 'an': %s%n", ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Sorted by string length: %s%n", ListOperations.sortByLength(strings));
        System.out.printf("Are all numbers even? %b%n", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("The smallest number greater than 4: %d%n", ListOperations.findMinGreaterThan(numbers, 4));
        System.out.printf("Line lengths: %s%n", ListOperations.convertToLengths(strings));
    }
}
