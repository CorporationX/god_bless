package school.faang.bjs2_88218;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Максимальное число не найдено"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Среднее не найдено"));
    }

    public static long countStringsStartingWith(List<String> strings,
                                                char letter) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == letter)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings,
                                                                String particle) {
        return strings.stream()
                .filter(s -> s.contains(particle))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers,
                                            Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int numb) {
        return numbers.stream()
                .filter(n -> n > numb)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Числа в коллекции не найдены"));
    }


    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
