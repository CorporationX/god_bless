package school.faang.BJS2_58289;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println(OperationsWithNumbersAndStrings.calculateEventSum(numbers));
        System.out.println(OperationsWithNumbersAndStrings.maxNumber(numbers));
        System.out.println(OperationsWithNumbersAndStrings.avrNumber(numbers));
        System.out.println(OperationsWithNumbersAndStrings.countStringsStartingWith(strings, 'b'));
        System.out.println(OperationsWithNumbersAndStrings.filterStringsContainingSubstring(strings, "na"));
        System.out.println(OperationsWithNumbersAndStrings.sortStringsByLength(strings));
        System.out.println(OperationsWithNumbersAndStrings.allMatchCondition(numbers,
                (number) -> number >= 2));
        System.out.println(OperationsWithNumbersAndStrings.findMinGreaterThanValue(numbers, 3));
        System.out.println(OperationsWithNumbersAndStrings.convertStringsToLength(strings));
    }
}
