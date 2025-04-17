package school.faang.first_stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "12345678990");

        // Пример использования методов:
        log.info("Сумма четных чисел: {}", ListOperations.sumOfEvenNumbers(numbers));
        log.info("Максимум: {}", ListOperations.findMax(numbers));
        log.info("Среднее: {}", ListOperations.findAverage(numbers));
        log.info("Количество строк, начинающихся на 'a': {}",
                ListOperations.countStringsStartingWith(strings, 'a'));
        log.info("Строки, содержащие 'an': {}",
                ListOperations.filterStringsContainingSubstring(strings, "an"));
        log.info("Отсортированные по длине строки: {}", ListOperations.sortByLength(strings));
        log.info("Все ли числа чётные? {}", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        log.info("Наименьшее число больше 4: {}", ListOperations.findMinGreaterThan(numbers, 4));
        log.info("Длины строк: {}", ListOperations.convertToLengths(strings));
    }
}
