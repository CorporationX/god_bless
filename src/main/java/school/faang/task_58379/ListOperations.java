package school.faang.task_58379;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(ListOperations::isEven)
                .mapToInt(Integer::intValue)
                .sum();
    }

    static int sumOfEvenNumbersV1(List<Integer> numbers) {
        return numbers.stream()
                .filter(ListOperations::isEven)
                .reduce(0, (Integer::sum));
    }

    static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    static int findMaxV1(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::max);
    }

    static int findMaxV2(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

    }

    static long countStringsStartingWith(List<String> strings, char startingChar) {
        return strings.stream()
                .filter(s -> !s.isBlank() && s.charAt(0) == startingChar)
                .count();
    }

    static long countStringsStartingWithV1(List<String> strings, String prefix) {
        return strings.stream()
                .filter(str -> str.startsWith(prefix))
                .count();
    }

    static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .toList();
    }

    static List<String> sortByLengthV1(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

    }

    // allMatchCondition
    // Проверить, все ли элементы списка удовлетворяют определённому условию.
    // Метод должен принимать список чисел и предикат, возвращать true, если все элементы списка удовлетворяют условию.
    // Вход: List<Integer>, Predicate<Integer>, выход: boolean..
    static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }



    // findMinGreaterThan
    // convertToLengths

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
