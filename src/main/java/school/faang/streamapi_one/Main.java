package school.faang.streamapi_one;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "airplane", "bug");

        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Maximum: " + ListOperations.findMax(numbers));
        System.out.println("Average: " + ListOperations.findAverage(numbers));
        System.out.println("Amount of string beginning from 'a': "
                            + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Only strings including 'pl': "
                            + ListOperations.filterStringsContainingSubstring(strings, "pl"));
        System.out.println("Strings sorted by length: " + ListOperations.sortByLength(strings));
        System.out.println("Are all numbers is even? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Minimum number is greater than 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Length of strings: " + ListOperations.convertToLengths(strings));
    }
}
