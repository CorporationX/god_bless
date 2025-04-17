package school.faang.bjs2_70749;

import java.util.Arrays;
import java.util.List;

import static school.faang.bjs2_70749.ListOperations.allMatchCondition;
import static school.faang.bjs2_70749.ListOperations.countStringsStartingWith;
import static school.faang.bjs2_70749.ListOperations.filterStringsContainingSubstring;
import static school.faang.bjs2_70749.ListOperations.getAverage;
import static school.faang.bjs2_70749.ListOperations.findMax;
import static school.faang.bjs2_70749.ListOperations.sortByLength;
import static school.faang.bjs2_70749.ListOperations.sumOfEvenNumbers;
import static school.faang.bjs2_70749.ListOperations.toLengths;

public class Main {
    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, null, 5, 6);
    private static final List<String> STRINGS = Arrays.asList("apple", "banana", null, "cherry", "date");

    public static void main(String[] args) {
        System.out.println("Sum of even numbers: " + sumOfEvenNumbers(NUMBERS));

        try {
            System.out.println("Maximum: " + findMax(NUMBERS));
        } catch (ValueNotFoundException ex) {
            System.out.println("Maximum: " + ex.getMessage());
        }

        try {
            System.out.println("Average: " + getAverage(NUMBERS));
        } catch (ValueNotFoundException ex) {
            System.out.println("Average: " + ex.getMessage());
        }

        System.out.println("Number of lines starting with 'a': "
                + countStringsStartingWith(STRINGS, 'a'));
        System.out.println("Strings containing 'an': "
                + filterStringsContainingSubstring(STRINGS, "an"));

        System.out.println("Sorted by string length: " + sortByLength(STRINGS));

        System.out.println("Are all the numbers even? " + allMatchCondition(NUMBERS, n -> n % 2 == 0));

        try {
            System.out.println("The smallest number greater than 4: "
                    + ListOperations.findMinGreaterThan(NUMBERS, 4));
        } catch (ValueNotFoundException ex) {
            System.out.println("The smallest number greater than 4: " + ex.getMessage());
        }

        System.out.println("Line lengths: " + toLengths(STRINGS));
    }
}
