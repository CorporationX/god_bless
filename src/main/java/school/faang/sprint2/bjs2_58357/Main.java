package school.faang.sprint2.bjs2_58357;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static school.faang.sprint2.bjs2_58357.ListOfOperations.*;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> predicate = number -> number % 2 == 0;
        List<Integer> listNull = new ArrayList<>();
        List<String> strings = List.of("apple", "banana", "cherry", "juice", "apple");

        log.info(String.format("Сумма четных чисел: %d", sumOfEvenNumbers(numbers)));
        log.info(String.format("Максимум: %d", maxNumber(numbers)));
        log.info(String.format("Среднее: %.2f", averageValue(numbers)));
        log.info(String.format("Количество строк, начинающихся на 'a': %d", stringCounter(strings, 'a')));
        log.info(String.format("Строки, содержащие 'ap': %s", filterBySubstring(strings, "ap")));
        log.info(String.format("Отсортированные по длине строки: %s", sortByLength(strings)));
        log.info(String.format("Все ли числа чётные?: %b", allElementsSatisfyCondition(numbers, predicate)));
        log.info(String.format("Наименьшее число больше 4: %d", findMinGreaterThan(numbers, 4)));
        log.info(String.format("Длины строк: %s", convertToLengths(strings)));
    }
}
