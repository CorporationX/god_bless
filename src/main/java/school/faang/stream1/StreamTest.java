package school.faang.stream1;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + sumEvenNumber(numbers));
        System.out.println("Максимум: " + findMax(numbers));
        System.out.println("Среднее: " + findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + sortByLength(strings));
        System.out.println("Все ли числа чётные? " + allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + convertToLengths(strings));
    }

    private static int sumEvenNumber(@NonNull List<Integer> numbers) {
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        return sum;
    }

    private static int findMax(@NonNull List<Integer> numbers) {
        Optional<Integer> maxElemnt = numbers.stream()
                .reduce(Integer::max);
        return maxElemnt.orElse(0);
    }

    private static double findAverage(@NonNull List<Integer> numbers) {
        double everage = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        return everage;
    }

    private static long countStringsStartingWith(@NonNull List<String> str, @NonNull char character) {
        long counterStr = str.stream()
                .filter(s -> s.charAt(0) == character)
                .count();
        return counterStr;
    }

    private static List<String> filterStringsContainingSubstring(@NonNull List<String> str, @NonNull String substring) {
        List<String> filteredStr = str.stream()
                .filter(s -> s.contains(substring))
                .toList();
        return filteredStr;
    }

    private static List<String> sortByLength(@NonNull List<String> str) {
        List<String> filteredStr = str.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        return filteredStr;
    }

    private static boolean allMatchCondition(@NonNull List<Integer> numbers, Predicate<Integer> condition) {
        boolean isCondition = numbers.stream()
                .allMatch(condition);
        return isCondition;
    }

    private static int findMinGreaterThan(List<Integer> numbers, @NonNull int number) {
        int result = numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compare)
                .orElse(0);
        return result;
    }

    private static List<Integer> convertToLengths(@NonNull List<String> str) {
        List<Integer> result = str.stream()
                .map(String::length)
                .toList();
        return result;
    }


}
