package school.faang.bjs2_88075;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "banana");

        System.out.println("Sum even numbers equal: "
                + ListOperations.findSumEvenNumbers(numbers));
        System.out.println("Max number equal: "
                + ListOperations.findMax(numbers));
        System.out.println("Average of numbers equals: "
                + ListOperations.findAverageOfNumbers(numbers));
        System.out.println("Number lines starting with 'b': "
                + ListOperations.countStringsStartingWith(strings, 'b'));
        System.out.println("Strings that contain 'ba' are equal: "
                + ListOperations.filterStringsContainingSpecificSubstring(strings, "ba"));
        System.out.println("Sorted by string length: "
                + ListOperations.sortingByLength(strings));
        System.out.println("Numbers greater than 0 and less than 7: "
                + ListOperations.isSatisfyCertainElementsCondition(numbers, n -> n > 0 && n < 7));
        System.out.println("The smallest number is greater than 3: "
                + ListOperations.findMinGreaterThan(numbers, 3));
        System.out.println("String lengths: "
                + ListOperations.convertToLengths(strings));
    }
}