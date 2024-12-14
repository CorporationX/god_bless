package school.faang.sprint2.bjs_46929;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        log.info("Сумма четных чисел: {}", OperationsWithLists.sumOfEvenNumbers(numbers));
        log.info("Максимум: {}", OperationsWithLists.findMax(numbers));
        log.info("Среднее: {}", OperationsWithLists.findAverage(numbers));
        log.info("Количество строк, начинающихся на 'a': {}",
                OperationsWithLists.countStringsStartingWith(strings, 'a'));
        log.info("Строки, содержащие 'an': {}",
                OperationsWithLists.filterStringsContainingSubstring(strings, "an"));
        log.info("Отсортированные по длине строки: {}", OperationsWithLists.sortByLength(strings));
        boolean ft = OperationsWithLists.allMatchCondition(numbers, n -> ((n % 2) == 0));
        log.info("Все ли числа чётные? {}", ft);
        log.info("Наименьшее число больше 3: {}", OperationsWithLists.findMinGreaterThan(numbers, 3));
        log.info("Длины строк: {}", OperationsWithLists.convertToLengths(strings));
    }
}


