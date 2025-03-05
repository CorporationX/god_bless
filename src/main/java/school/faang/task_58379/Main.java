package school.faang.task_58379;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "durian", "grape", "melon", "orange", "pear");
        List<Integer> emptyInt = List.of();
        List<String> emptyStr = List.of();

        log.info("\nСумма четных чисел:");
        log.info("{}", ListOperations.sumOfEvenNumbers(numbers));
        log.info("{}", ListOperations.sumOfEvenNumbersV1(numbers));
        log.info("{}", ListOperations.sumOfEvenNumbersV1(emptyInt));

        log.info("\nМаксимум:");
        log.info("{}", ListOperations.findMax(numbers));
        log.info("{}", ListOperations.findMaxV1(numbers));
        log.info("{}", ListOperations.findMaxV2(numbers));
        log.info("{}", ListOperations.findMax(emptyInt));

        log.info("\nСреднее:");
        log.info("{}", ListOperations.findAverage(numbers));
        log.info("{}", ListOperations.findAverage(emptyInt));

        log.info("\nКоличество строк, начинающихся на 'a':");
        log.info("{}", ListOperations.countStringsStartingWith(strings, 'a'));
        log.info("{}", ListOperations.countStringsStartingWith(emptyStr, 'a'));
        log.info("{}", ListOperations.countStringsStartingWithV1(strings, "a"));
        log.info("{}", ListOperations.countStringsStartingWithV1(emptyStr, "a"));

        log.info("\nСтроки, содержащие 'an':");
        log.info("{}", ListOperations.filterStringsContainingSubstring(strings, "an"));
        log.info("{}", ListOperations.filterStringsContainingSubstring(strings, ""));
        log.info("{}", ListOperations.filterStringsContainingSubstring(emptyStr, "an"));

        log.info("\nОтсортированные по длине строки:");
        log.info("{}", ListOperations.sortByLength(strings));
        log.info("{}", ListOperations.sortByLengthV1(strings));
        log.info("{}", ListOperations.sortByLengthV1(emptyStr));


        log.info("\nВсе ли числа чётные?");
        log.info("{}", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        log.info("{}", ListOperations.allMatchCondition(numbers, n -> n < 11));
        log.info("{}", ListOperations.allMatchCondition(numbers, n -> n < 11));


    }
}
