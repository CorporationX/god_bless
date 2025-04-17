package school.faang.bjs2_70706;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbersWithNull = Arrays.asList(1, 2, 3, null, 4, 5, 6, null);
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6);
        List<Integer> emptyList = new ArrayList<>();
        List<String> stringsWithNull = Arrays.asList(
            "apple", "banana", "cherry", "date", "", "animal", "island", "angle", null, "  "
        );
        List<String> strings = Arrays.asList(
            "apple", "banana", "cherry", "date", "", "animal", "island", "angle", "  "
        );

        log.info("Сумма четных чисел: {}", ListOperations.sumOfEvenNumbers(numbers));
        log.info("Максимум: {}", ListOperations.findMax(numbers));
        log.info("Максимум (null): {}", ListOperations.findMax(numbersWithNull));
        log.info("Среднее: {}", ListOperations.findAverage(numbers));
        log.info("Среднее: {}", ListOperations.findAverage(numbersWithNull));
        log.info("Количество строк, начинающихся на 'a': {}",
            ListOperations.countStringsStartingWith(strings, 'a'));
        log.info("Количество строк, начинающихся на 'a': {}",
            ListOperations.countStringsStartingWith(stringsWithNull, 'a'));
        log.info("Строки, содержащие 'an': {}",
            ListOperations.filterStringsContainingSubstring(strings, "an"));
        log.info("Строки, содержащие 'an': {}",
            ListOperations.filterStringsContainingSubstring(stringsWithNull, "an"));
        log.info("Отсортированные по длине строки: {}", ListOperations.sortByLength(strings));
        log.info("Отсортированные по длине строки: {}", ListOperations.sortByLength(stringsWithNull));
        log.info("Все ли числа чётные? {}", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        log.info("Все ли числа чётные? {}", ListOperations.allMatchCondition(evenNumbers, n -> n % 2 == 0));
        log.info("Наименьшее число больше 4: {}", ListOperations.findMinGreaterThan(numbers, 4));
        log.info("Наименьшее число больше 4: {}", ListOperations.findMinGreaterThan(numbersWithNull, 4));
        log.info("Длины строк: {}", ListOperations.convertToLengths(stringsWithNull));
        log.info("Длины строк: {}", ListOperations.convertToLengths(strings));
    }
}