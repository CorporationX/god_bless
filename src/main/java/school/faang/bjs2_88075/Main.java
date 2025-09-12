package school.faang.bjs2_88075;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "banana");

        System.out.println("Sum even numbers equal: " + ListOperations.findSumEvenNumbers(numbers));
        System.out.println("Max number equal: " + ListOperations.findMax(numbers));
        System.out.println("Average of numbers equals: " + ListOperations.findAverageOfNumbers(numbers));
        System.out.println("The number lines starting with 'b': " + ListOperations.countStringsStartingWith(strings, 'b'));
        System.out.println("Strings that contain 'ba' are equal: " + ListOperations.filterStringsContainingSpecificSubstring(strings, "ba"));
        System.out.println("Sorted by string length: " + ListOperations.sortingByLength(strings));
        System.out.println("Numbers greater than zero and less than seven: " + ListOperations.satisfyCertainElementsCondition(numbers, n -> n > 0 && n < 7));
        System.out.println("The smallest number is greater than three: " + ListOperations.findMinGreaterThan(numbers, 3));
        System.out.println("String lengths: " + ListOperations.convertToLengths(strings));
    }
}