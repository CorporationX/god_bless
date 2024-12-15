package school.faang.task_47130;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(12, 21, 33, 46, 59, 66);
        final List<String> strings = Arrays.asList("apple", "banana", "cherry", "kalina", "malina");

        System.out.println("Are all numbers even?: " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Max element: " + ListOperations.findMax(numbers));
        System.out.println("Average value: " + ListOperations.findAverage(numbers));
        System.out.println("Number of strings starting with 'a': "
                + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Strings containing 'al': "
                + ListOperations.filterStringsContainingSubstring(strings, "al"));
        System.out.println("Strings sorted by length: " + ListOperations.sortByLength(strings));
        System.out.println("Find min number greater than 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("String lengths: " + ListOperations.convertToLengths(strings));
    }
}