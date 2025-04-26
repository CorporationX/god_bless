package school.faang.streamapi_practice_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Sum of even numbers: " + OperationList.sumEvenNumbers(numbers));
        System.out.println("Maximum: " + OperationList.findMax(numbers));
        System.out.println("Average: " + OperationList.findAverage(numbers));
        System.out.println("Number of strings starting with 'a': " +
                OperationList.countStringsStartingWith(strings, 'a'));
        System.out.println("Strings containing 'an': " + OperationList.filterStringsBySubstring(strings, "an"));
        System.out.println("Strings sorted by length: " + OperationList.sortByLength(strings));
        System.out.println("Are all numbers even? " + OperationList.isMatchingCondition(numbers, n -> n % 2 == 0));
        System.out.println("Minimum number greater than 4: " + OperationList.findMinGreaterThan(numbers, 4));
        System.out.println("String lengths: " + OperationList.extractLengths(strings));
    }
}