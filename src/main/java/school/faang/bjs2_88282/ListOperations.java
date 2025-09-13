package school.faang.bjs2_88282;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOperations {
    public static int countEvenNumbersSum(List<Integer> numbers) throws Exception {
        if (numbers == null) {
            throw new RuntimeException("Список чисел равен null.");
        }
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(List<Integer> numbers) throws Exception {
        if (numbers == null) {
            throw new RuntimeException("Список чисел равен null.");
        }
        return numbers.stream()
                .mapToInt(Integer::intValue).max()
                .orElse(0);
    }

    public static Double averageValue(List<Integer> numbers) throws Exception {
        if (numbers == null) {
            throw new RuntimeException("Список чисел равен null.");
        }
        IntStream intStream = numbers.stream()
                .mapToInt(Integer::intValue);
        return intStream.average()
                .orElse(0);
    }

    public static long countStringsStartWithSymbol(List<String> strings, char symbol) throws Exception {
        if (strings == null) {
            throw new RuntimeException("Список строк равен null.");
        }
        return strings.stream()
                .filter(letter -> letter.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> selectStringsWithSubstring(List<String> strings, String substring)
            throws Exception {
        if (strings == null || substring == null) {
            throw new RuntimeException("Список строк или/и подстрока равны null.");
        }
        return strings.stream()
                .filter(text -> text.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) throws Exception {
        if (strings == null) {
            throw new RuntimeException("Список строк равен null.");
        }
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors
                        .toList());
    }

    public static boolean checkCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        if (numbers == null || predicate == null) {
            throw new RuntimeException("Список чисел или/и число для проверки равны null");
        }
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinSatisfyCondition(List<Integer> numbers, int conditionNumber) {
        if (numbers == null) {
            throw new RuntimeException("Список чисел или/и число для проверки равны null");
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x > conditionNumber)
                .min()
                .orElse(0);
    }

    public static List<Integer> convertListStringToListLength(List<String> strings) {
        if (strings == null) {
            throw new RuntimeException("Список строк равен null.");
        }
        return strings.stream().map(String::length).collect(Collectors.toList());
    }











}
