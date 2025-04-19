package school.faang.train_stream_api_1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(19, 2, 3, 4, 5, 6, 9, 10, 13, 14, 19);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "chess", "playstation");

        log.info("Сумма четных чисел: {}", ListOperations.sumOfEvenNumbers(numbers));
        log.info("Максимум: {}", +ListOperations.findMax(numbers));
        log.info("Среднее: {}", +ListOperations.findAverage(numbers));
        log.info("Количество строк, начинающихся на 'a': {}", ListOperations.countStringsStartingWith(strings, "a"));
        log.info("Строки, содержащие 'st': {}", ListOperations.filterStringsContainingSubstring(strings, "st"));
        log.info("Отсортированные по длине строки: {}", ListOperations.sortByLength(strings));
        log.info("Все ли числа чётные? {}", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        log.info("Наименьшее число больше 4: {}", ListOperations.findMinGreaterThan(numbers, 4));
        try {
            log.info("Наименьшее число больше 19: {}",
                    ListOperations.findMinGreaterThan(numbers, 19));
        } catch (NoSuchElementException e) {
            log.error("Ошибка при поиске числа больше 19: {}", e.getMessage());
        }
        log.info("Длины строк: {}", ListOperations.convertToLengths(strings));
    }
}
