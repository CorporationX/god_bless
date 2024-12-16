package school.faang.sprint_1.task_streamapi1bjs2n47048;

import java.util.Arrays;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class StreamApiMain {
    public static void main(String[] args) {
        Logger loggerMain = LoggerFactory.getLogger("loggerMain");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(2, 4, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        try {
            loggerMain.info("Сумма четных чисел: {}", ListOperations.sumOfEvenNumbers(numbers));
            loggerMain.info("Максимум: {}", ListOperations.findMax(numbers));
            loggerMain.info("Среднее: {}", ListOperations.findAverage(numbers));
            loggerMain.info("Количество строк, начинающихся на 'a': {}",
                     ListOperations.countStringsStartingWith(strings, 'a'));
            loggerMain.info("Строки, содержащие 'an': {}",
                    ListOperations.filterStringsContainingSubstring(strings, "an"));
            loggerMain.info("Отсортированные по длине строки: {}",
                    ListOperations.sortByLength(strings));
            loggerMain.info("Все ли числа чётные? {}", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
            loggerMain.info("Все ли числа чётные? {}", ListOperations.allMatchCondition(numbers2, n -> n % 2 == 0));
            loggerMain.info("Наименьшее число больше 4: {}", ListOperations.findMinGreaterThan(numbers, 4));
            loggerMain.info("Длины строк: {}", ListOperations.convertToLengths(strings));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
