package school.faang.bjs2_70739;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        log.info("Сумма четных чисел: {}", ListOperations.sumOfEvenNumbers(numbers));
        log.info("Максимум: {}", ListOperations.findMaxNumber(numbers));
        log.info("Среднее: {}", ListOperations.countAverageNumber(numbers));
        log.info("Количество строк, начинающихся на 'a': {}", ListOperations.countStringsStartWith(strings, 'a'));
        log.info("Строки, содержащие 'an': {}", ListOperations.stringContainsSubstring(strings, "an"));
        log.info("Отсортированные по длине строки: {}", ListOperations.sortStringsByLength(strings));
        log.info("Все ли числа чётные? {}", ListOperations.checkListOfIntegers(numbers, n -> n % 2 == 0));
        log.info("Наименьшее число больше 4: {}", ListOperations.findFirstBiggerThanCondition(numbers, 4));
        log.info("Длины строк: {}", ListOperations.mapStringsIntoLengths(strings));
    }
}
