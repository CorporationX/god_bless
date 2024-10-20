package school.faang.bjs2_35687;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 7);
        List<String> strings = Arrays.asList("apple", "apricot", "banana", "avocado", "berry");

        System.out.println(ListOperations.sumEvenNumbers(numbers));
        System.out.println(ListOperations.findMaxElement(numbers));
        System.out.println(ListOperations.findAverageOfNumbers(numbers));
        System.out.println(ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println(ListOperations.filterStringsContaining(strings, "ap"));
        System.out.println(ListOperations.sortStringsByLength(strings));
        System.out.println(ListOperations.allMatchCondition(numbers, integer -> integer > 0));
        System.out.println(ListOperations.findMinGreaterThan(numbers, 6));
        System.out.println(ListOperations.mapStringsToLengths(strings));
    }
}
