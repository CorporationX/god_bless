package school.faang.streamAPI_one;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Sum of even numbers: " + ListOfOperations.sumOfEvenNumbers(numbers));
        System.out.println("Maximum: " + ListOfOperations.findMax(numbers));
        System.out.println("Average: " + ListOfOperations.findAverage(numbers));
        System.out.println("Number of strings starting with 'a': " + ListOfOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Strings having 'an': " + ListOfOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Strings sorted by length: " + ListOfOperations.sortByLength(strings));
        System.out.println("Are all the numbers even? " + ListOfOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("The smallest humber bigger than 4: " + ListOfOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Strings' lengths: " + ListOfOperations.convertToLengths(strings));
    }
}
