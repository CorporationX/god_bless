package school.faang.stream_api1;

import java.util.List;

import static school.faang.stream_api1.ListOperations.allElementsMatchCondition;
import static school.faang.stream_api1.ListOperations.countStringsStartingWith;
import static school.faang.stream_api1.ListOperations.filterStringsContaining;
import static school.faang.stream_api1.ListOperations.findMaxElement;
import static school.faang.stream_api1.ListOperations.findSmallestGreaterThan;
import static school.faang.stream_api1.ListOperations.getAverage;
import static school.faang.stream_api1.ListOperations.sortStringsByLength;
import static school.faang.stream_api1.ListOperations.sumOfEvenNumbers;
import static school.faang.stream_api1.ListOperations.transformToStringLengths;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 7, 6, 2, 18, 13, 0);
        List<String> strings = List.of("apple", "banana", "avocado", "orange", "apricot");

        System.out.printf("Sum of even numbers: %s%n", sumOfEvenNumbers(numbers));
        System.out.printf("Max element: %s%n", findMaxElement(numbers));
        System.out.printf("Average: %s%n", getAverage(numbers));
        System.out.printf("Count strings starting with 'a': %s%n", countStringsStartingWith(strings, 'a'));
        System.out.printf("Strings contains 'an': %s%n", filterStringsContaining(strings, "an"));
        System.out.printf("Strings sorted by length : %s%n", sortStringsByLength(strings));
        System.out.printf("All numbers greater than 0 : %s%n", allElementsMatchCondition(numbers, n -> n > 0));
        System.out.printf("Smallest greater than 6 : %s%n", findSmallestGreaterThan(numbers, 6));
        System.out.printf("String lengths : %s%n", transformToStringLengths(strings));
    }
}