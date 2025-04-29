package school.faang.stream_api.bjs2_70827.stream_api1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final List<Integer> numbers = IntStream.rangeClosed(1, 20).boxed().toList();
        final List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        log.info("Сумма четных чисел: {}", ListOperations.sumOfEvenNumbers(numbers));
        log.info("Максимум: {}", ListOperations.findMax(numbers));
        try {
            log.info("Максимум: {}", ListOperations.findMax(new ArrayList<>()));
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
        }
        log.info("Среднее: {}", ListOperations.findAverage(numbers));
        log.info("Количество строк, начинающихся на 'a': {}", ListOperations.countStringsStartingWith(strings, 'a'));
        log.info("Строки, содержащие 'an': {}", ListOperations.filterStringsContainingSubstring(strings, "an"));
        log.info("Отсортированные по длине строки: {}", ListOperations.sortByLength(strings));
        log.info("Все ли числа чётные? {}", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        log.info("Наименьшее число больше 4: {}", ListOperations.findMinGreaterThan(numbers, 4));
        log.info("Длины строк: {}", ListOperations.convertToLengths(strings));
    }
}
