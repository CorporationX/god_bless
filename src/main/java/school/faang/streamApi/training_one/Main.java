package school.faang.streamApi.training_one;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 6).boxed().toList();
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        log.info("Сумма четных чисел: {}", ListOperations.sumEvenNumbers(numbers));
        log.info("Максимум: {}", ListOperations.findMaxNumber(numbers));
        log.info("Среднее: {}", ListOperations.findMean(numbers));
        log.info("Количество строк, начинающихся на 'a': {}", ListOperations.countStringsStatingWith(strings, 'a'));
        log.info("Строки, содержащие 'an': {}", ListOperations.filterBySubstring(strings, "an"));
        log.info("Отсортированные по длине строки: {}", ListOperations.sortByLength(strings));
        log.info("Все ли числа чётные? {}", ListOperations.checkCondition(numbers, n -> n % 2 == 0));
        log.info("Наименьшее число больше 4: {}", ListOperations.findMinNumberComparedTo(numbers, 4));
        log.info("Длины строк: {}", ListOperations.toStringLengthList(strings));
    }
}