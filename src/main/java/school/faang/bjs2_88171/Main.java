package school.faang.bjs2_88171;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        List<Integer> emptyNumbers = Collections.emptyList();

        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Maximum: " + ListOperations.findMax(numbers));
        System.out.println("Average: " + ListOperations.findAverage(numbers));
        System.out.println("Strings which start with 'a': " + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("String containing 'an': " + ListOperations.filterBySubstring(strings, "an"));
        System.out.println("Strings sorted by length: " + ListOperations.sortByLength(strings));
        System.out.println("Are all numbers even? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Smallest number, but greater than 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("String length: " + ListOperations.mapToLengths(strings));

        try {
            System.out.println("Maximum: " + ListOperations.findMax(emptyNumbers));
        } catch (NoSuchElementException e) {
            System.out.println(("Error: " + e.getMessage()));
        }

        try {
            System.out.println("Average: " + ListOperations.findAverage(emptyNumbers));
        } catch (NoSuchElementException e) {
            System.out.println(("Error: " + e.getMessage()));
        }
    }
}
