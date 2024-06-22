package faang.school.godbless.BJS2_10513;


import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class SomeClass {

    public static Integer sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Integer findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static Double findAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

    }

    public static Integer countLinesStartingWithCharacter(List<String> lines, String character) {
        return (int) lines.stream()
                .filter(s -> s.startsWith(character))
                .count();
    }

    public static List<String> filterLinesContainsSubstring(List<String> lines, String substring) {
        return lines.stream()
                .filter(s -> s.toLowerCase().contains(substring.toLowerCase()))
                .toList();
    }

    public static List<String> sortLinesByLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean checkAllElementsForTheCondition(List<T> lines, Predicate<T> condition) {
        return lines.stream()
                .allMatch(condition);
    }

    public static List<Integer> mapToLength(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }

    public static int findMinAmongMax(List<Integer> numbers, int number) {
        return numbers.stream()
                .distinct()
                .filter(n -> n > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Not found value"));
    }

}
