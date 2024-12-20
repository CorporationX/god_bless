package school.faang.task_47198;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 7);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Use the ListOperations class to call the static method
        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Max element: " + ListOperations.findMaxElement(numbers));
        System.out.println("Average: " + ListOperations.calculateAverage(numbers));
        System.out.println("Count starting with 'b': " + ListOperations.countStringsStartingWith(strings, 'b'));
        System.out.println("Filtered by 'an': " + ListOperations.filterStringsBySubstring(strings, "an"));
        System.out.println("Sorted by length: " + ListOperations.sortStringsByLength(strings));
        System.out.println("All greater than 2: " + ListOperations.allElementsMatch(numbers, num -> num > 2));
        System.out.println("Smallest greater than 6: " + ListOperations.findSmallestGreaterThan(numbers, 6));
        System.out.println("String lengths: " + ListOperations.mapStringsToLengths(strings));
    }
}
