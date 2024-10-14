package ru.kraiush.BJS2_35612;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Maximum: " + ListOperations.findMax(numbers));
        System.out.println("Average: " + ListOperations.findAverage(numbers));
        System.out.println("Number of strings starting with 'a': " + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Strings containing 'an': " + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Sorted by length strings: " + ListOperations.sortByLength(strings));
        System.out.println("Are all numbers even? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("The smallest number greater than 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("String lengths: " + ListOperations.convertToLengths(strings));
    }
}
