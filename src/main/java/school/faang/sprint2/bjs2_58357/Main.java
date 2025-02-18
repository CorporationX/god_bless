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

        log.info("Сумма четных чисел: {}", sumOfEvenNumbers(numbers));
        log.info("Максимум: {}", maxNumber(numbers));
        log.info("Среднее: {}", averageValue(numbers));
        log.info("Количество строк, начинающихся на 'a': {}", stringCounter(strings, 'a'));
        log.info("Строки, содержащие 'an': {}", filterBySubstring(strings, "ap"));
        log.info("Отсортированные по длине строки: {}", sortByLength(strings));
        log.info("Все ли числа чётные?: {}", allElementsSatisfyCondition(numbers, predicate));
        log.info("Наименьшее число больше 4: {}", findMinGreaterThan(numbers, 4));
        log.info("Длины строк: {}", convertToLengths(strings));

    }
}
