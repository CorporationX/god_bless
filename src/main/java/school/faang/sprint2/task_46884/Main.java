package school.faang.sprint2.task_46884;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "anton", "as");
        System.out.println("Sum even numbers: " + ListOperations.sumEven(numbers));
        System.out.println("Max number: " + ListOperations.max(numbers));
        System.out.println("Average: " + ListOperations.avg(numbers));
        System.out.println("Number of strings starting with a: " + ListOperations.stringStartsWith(strings, 'a'));
        System.out.println("Strings, having 'an': " + ListOperations.filterStringsHasSubstrings(strings, "an"));
        System.out.println("Sort strings: " + ListOperations.sortStringsByLength(strings));
        System.out.println("Are all numbers even? " + ListOperations.allMatchCondition(numbers, (n) -> n % 2 == 0));
        System.out.println("Min number greater than 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Length of the strings: " + ListOperations.mapToLength(strings));
    }
}
