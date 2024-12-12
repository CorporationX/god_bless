package school.faang.task_46855;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("The sum of even numbers: " + StreamOperations.sumOfEvenNumbers(numbers));
        System.out.println("Max: " + StreamOperations.findMax(numbers));
        System.out.println("Average: " + StreamOperations.findAverage(numbers));
        System.out.println("The number of lines starting with 'a': "
                + StreamOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Lines containing 'an': "
                + StreamOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Lines sorted by length: " + StreamOperations.sortByLength(strings));
        System.out.println("Are all the numbers even? " + StreamOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("The smallest number greater than 4: "
                + StreamOperations.findMinGreaterThan(numbers, 4));
        System.out.println("The lengths of the lines: " + StreamOperations.convertToLengths(strings));
    }
}
