package dima.evseenko.streamapi1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "amazon");

        System.out.println(ListOperations.sumOfEvenNumbers(numbers));
        System.out.println(ListOperations.findMax(numbers));
        System.out.println(ListOperations.findAverage(numbers));
        System.out.println(ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println(ListOperations.filterStringsContainingSubstring(strings, "ap"));
        System.out.println(ListOperations.sortByLength(strings));
        System.out.println(ListOperations.allMatchCondition(numbers, (number) -> number % 2 == 0));
        System.out.println(ListOperations.findMinGreaterThan(numbers, 3));
        System.out.println(ListOperations.convertToLengths(strings));
    }
}
