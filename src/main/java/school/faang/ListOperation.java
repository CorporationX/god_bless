package school.faang;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperation {

    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List isEmpty"));
    }

    public static double averageNubmers(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List isEmpty"));
    }

    public static long startNumbersSpecificChar(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == startChar)
                .count();
    }

    public static List<String> listSpecificSubstring(List<String> strings, String substrings) {
        return strings.stream()
                .filter(s -> s.contains(substrings))
                .collect(Collectors.toList());
    }

    public static List<String> stringSize(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean elementsList(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int minElement(List<Integer> numbers, int number) {
        Optional<Integer> minNubmer = numbers.stream()
                .filter(n -> n > number)
                .min(Integer::compareTo);
        return minNubmer.orElse(-1);
    }

    public static List<Integer> convertToLenght(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
