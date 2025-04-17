package school.faang.bjs2_70749;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, null, 5, 6);
    private static final List<String> STRINGS = Arrays.asList("apple", "banana", null, "cherry", "date");

    public static void main(String[] args) {


        // Пример использования методов:
        System.out.println("Sum of even numbers: " + ListOperations.sumOfEvenNumbers(NUMBERS));

        try {
            System.out.println("Maximum: " + ListOperations.findMax(NUMBERS));
        } catch (ValueNotFoundException ex) {
            System.out.println("Maximum: " + ex.getMessage());
        }

        try {
            System.out.println("Average: " + ListOperations.findAverage(NUMBERS));
        } catch (ValueNotFoundException ex) {
            System.out.println("Average: " + ex.getMessage());
        }

        System.out.println("Number of lines starting with 'a': "
                + ListOperations.countStringsStartingWith(STRINGS, 'a'));
        System.out.println("Strings containing 'an': "
                + ListOperations.filterStringsContainingSubstring(STRINGS, "an"));

        System.out.println("Sorted by string length: " + ListOperations.sortByLength(STRINGS));

        System.out.println("Are all the numbers even? " + ListOperations.allMatchCondition(NUMBERS, n -> n % 2 == 0));

        try {
            System.out.println("The smallest number greater than 4: " + ListOperations.findMinGreaterThan(NUMBERS, 4));
        } catch (ValueNotFoundException ex) {
            System.out.println("The smallest number greater than 4: " + ex.getMessage());
        }

        System.out.println("Line lengths: " + ListOperations.convertToLengths(STRINGS));
    }
}
