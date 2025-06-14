package school.faang.bjs2_80765;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 4, 5, 6, 7, 10, 15, 9, 20);
        List<String> strings = Arrays.asList("Hello", "cucumber", "dog", "cat", "Lemon");

        log.info("Сумма: {}", countSum(nums));
        log.info("Максимальный элемент: {}", findMax(nums));
        log.info("Среднее ариф.:{}", countAverage(nums));
        log.info("Число строк начинающийся на `h`: {}", countStringsStartingWith(strings, 'h'));
        log.info("Строки содержащие \"r\": {}", filteredStringsBySubString(strings, "r"));
        log.info("Отсортированные строки по длине: {}", sortedStrings(strings));
        log.info("Все ли числа больше 0: {}", allMatchCondition(nums, num -> num > 0));
        log.info("Минимальный элемент после числа 7: {}", findMinBeforeNum(nums, 7));
        log.info("Конвертация строк в длину: {}", convertToLengths(strings));

    }

    private static int countSum(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::sum);
    }

    private static int findMax(List<Integer> nums) {
        return nums.stream()
                .max(Comparator.comparingInt(num -> num))
                .orElseThrow(() -> new IllegalArgumentException("Empty list passed"));
    }

    private static double countAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Empty list passed"));
    }

    private static long countStringsStartingWith(List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .count();
    }

    private static List<String> filteredStringsBySubString(List<String> strings, String subString) {
        return strings.stream()
                .filter(string -> string.contains(subString))
                .toList();
    }

    private static List<String> sortedStrings(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static boolean allMatchCondition(List<Integer> nums, Predicate<Integer> filter) {
        return nums.stream()
                .allMatch(filter);
    }

    private static int findMinBeforeNum(List<Integer> nums, int target) {
        return nums.stream()
                .filter(num -> num > target).mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Empty list passed"));
    }

    private static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
