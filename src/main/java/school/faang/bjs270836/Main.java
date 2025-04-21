package school.faang.bjs270836;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Max: " + ListOperations.findMax(numbers));
        System.out.println("Average: " + ListOperations.findAverage(numbers));
        System.out.println("Strings, contains 'an': " + ListOperations.filterStringsContainingSubstring(strings, 'e'));
        System.out.println("Sorted by length of strings: " + ListOperations.sortByLength(strings));
        System.out.println("Are all numbers even? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Minimum number which greater than 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Strings lengths: " + ListOperations.convertToLengths(strings));
    }
}
