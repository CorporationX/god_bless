package school.faang.streamapi1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 5, 20, 15, 3, 7);
        List<String> words = List.of("Apple", "Apricot", "Banana", "Grape",
                "Mango", "Carrot", "Cucumber", "Tomato", "Potato");

        log.debug("Сумма четных чисел: {}", ListOperations.sumOfEvenNumbers(nums));
        log.info("Максимум: {}", ListOperations.findMax(nums));
        log.debug("Среднее: {}", ListOperations.findAverage(nums));
        log.debug("Количество строк, начинающихся на 'a': {}", ListOperations.countStringsStartingWith(words, 'A'));
        log.debug("Строки, содержащие 'Ap' : {}", ListOperations.filterStringsContainingSubstring(words, "Ap"));
        log.debug("Отсортированные по длине строки: {}", ListOperations.sortByLength(words));
        log.info("Все ли числа чётные? {}", ListOperations.allMatchCondition(nums, n -> n % 2 == 0));
        log.info("Наименьшее число больше 6: {}", ListOperations.findMinGreaterThan(nums, 6));
        log.debug("Длины строк: {}", ListOperations.convertToLengths(words));
    }
}
