package school.faang.naughtwoBJS258366;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Maximum: " + ListOperations.findMaxNumber(numbers));
        System.out.println("Average: " + ListOperations.averageOfNumbers(numbers));
        System.out.println("Number of lines starting with 'a': " + ListOperations.countStringsStartWith(strings, 'a'));
        System.out.println("Lines containing 'an': " + ListOperations.filterContainsSubstring(strings, "an"));
        System.out.println("Sorted by string length: " + ListOperations.sortStringsByLength(strings));
        System.out.println("Are all numbers even? " + ListOperations.allNumbersCondition(numbers, n -> n % 2 == 0));
        System.out.println("The smallest number greater than 4: " + ListOperations.findMinNumberGreaterThan(numbers, 4));
        System.out.println("Line lengths: " + ListOperations.convertStringsToLengths(strings));
    }
}
