package faang.school.godbless.train.stream.api.one;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiTrainingFirst {

    public static long sumEven(List<Integer> integers) {
        return integers.stream()
                .mapToInt(number -> number)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public static int getMax(List<Integer> integers) {
        return integers.stream()
                .mapToInt(number -> number)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List shouldn't be empty"));
    }

    public static double getAverage(List<Integer> integers) {
        return integers.stream()
                .mapToInt(number -> number)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List shouldn't be empty"));
    }

    public static long countLinesStartsWith(List<String> lines, String prefix) {
        return lines.stream()
                .filter(line -> line.startsWith(prefix))
                .count();
    }

    public static List<String> getListContains(List<String> lines, String subString) {
        return lines.stream()
                .filter(line -> line.contains(subString))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatch(List<String> lines, Predicate<String> predicate) {
        return lines.stream()
                .allMatch(predicate);
    }

    public static int minButMoreThan(List<Integer> numbers, int lowerLimit) {
        return numbers.stream()
                .sorted()
                .filter(number -> number > lowerLimit)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No number greater than lowerLimit was found in the list"));
    }

    public static List<Integer> convert(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
