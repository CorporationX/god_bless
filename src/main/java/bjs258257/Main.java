package bjs258257;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Maximum: " + ListOperations.findMax(numbers));
        System.out.println("Average: " + ListOperations.findAverage(numbers));
        System.out.println("Number of lines starting with 'a': "
                + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Strings contains 'an': "
                + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Sorted by string length: "
                + ListOperations.sortByLength(strings));
        System.out.println("Are all the numbers even? "
                + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("The smallest number is greater than 4: "
                + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("String lengths: " + ListOperations.convertToLengths(strings));
    }
}
