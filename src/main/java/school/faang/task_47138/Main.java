package school.faang.task_47138;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "bad", "dad");

        System.out.println(String.format("1. Sum of even numbers = %d", ListOperations.sumOfEvenNumbers(numbers)));
        System.out.println(String.format("2. Max number in list = %d", ListOperations.maxNumberInList(numbers)));
        System.out.println(String.format("3. Average in list = %.2f", ListOperations.averageOfList(numbers)));
        System.out.println(String.format("4. Numbers of lines begins on '%s' = %d", 'a',
                ListOperations.countLinesBeginsOn(strings, 'b')));
        System.out.println(String.format("5. Lines contains '%s' = %s", "an",
                ListOperations.filterLinesBeginOn(strings, "da").toString()));
        System.out.println(String.format("6. Sort lines: %s", ListOperations.sortByLength(strings).toString()));
        System.out.println(String.format("7. Are all numbers even? %s",
                ListOperations.allMatchCondition(numbers, n -> n % 2 == 0)));
        System.out.println(String.format("8. The smallest number is greater %d - %d", 4,
                ListOperations.findMinGreaterThan(numbers, 4)));
        System.out.println(String.format("9. String lengths: %s", ListOperations.convertToLengths(strings).toString()));
    }
}
