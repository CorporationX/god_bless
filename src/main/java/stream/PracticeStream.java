package stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PracticeStream {

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream().
                filter(element -> element % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int maxNumbers(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo).
                orElse(0);
    }

    public static double averageNumbers(List<Integer> numbers) {
        return numbers.stream().
                mapToInt(Integer::intValue).
                average().
                orElse(0);
    }

    public static boolean ountStringsWithStartingCharacter(List<String> line, String substring) {
        return line.stream().
                allMatch(element -> element.startsWith(substring));
    }

    public static List<String> filterStrings(List<String> line, String substring) {
        return line.stream().
                filter(element -> element.contains(substring)).
                collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> line) {
        return line.stream().
                sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean checkAllElements(List<String> line, Predicate<String> predicate) {
        return line.stream()
                .allMatch(predicate);
    }

    public static int findSmallestElementGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream().
                filter(element -> element > number).min(Integer::compareTo).orElseThrow();
    }

    public static List<Integer> conversionString(List<String> line) {
        return line.stream().map(String::length).collect(Collectors.toList());
    }
}