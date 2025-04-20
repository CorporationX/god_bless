package school.faang.bjs2_71988;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 6, 5);
    private static final List<String> STRINGS = Arrays.asList("apple", "banana", "cherry", "date", "aprikot", "ananas");

    public static void main(String[] args) {
        log.info("Сумма четных чисел: {}.", ListOperations.findSumOfEvenNumbers(NUMBERS));
        log.info("Максимум: {}.", ListOperations.findMaxNum(NUMBERS));
        log.info("Среднее: {}.", ListOperations.findAverage(NUMBERS));
        log.info("Количество строк, начинающихся на 'a': {}.", ListOperations.findNumOfStringsWithFilter(STRINGS, 'a'));
        log.info("Строки, содержащие 'an': {}", ListOperations.filterStringsBySubstring(STRINGS, "an"));
        log.info("Отсортированные по длине строки: {}.", ListOperations.sortStringsByLength(STRINGS));
        log.info("Все ли числа чётные? {}.", ListOperations.filterNums(NUMBERS, num -> num % 2 == 0));
        log.info("Наименьшее число больше 4: {}", ListOperations.findMinNumWithCondition(NUMBERS, 4));
        log.info("Длины строк: {}", ListOperations.convertStringsToStiringLengths(STRINGS));
    }
}
