package school.faang.streamApiFirst;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println(ListOperations.sumOfEvenNumbers(numbers));
        System.out.println(ListOperations.getMaxNumber(numbers));
        System.out.println(ListOperations.getAvgNumber(numbers));
        System.out.println(ListOperations.getNumberOfLines(strings, 'a'));
        System.out.println(ListOperations.getSortedListBySubstring(strings, "an"));
        System.out.println(ListOperations.sortByLength(strings));
        System.out.println(ListOperations.isSatisfiedByConditions(numbers, n -> n % 2 == 0));
        System.out.println(ListOperations.getMinNumber(numbers, 4));
        System.out.println(ListOperations.mapStringToInteger(strings));
    }
}
