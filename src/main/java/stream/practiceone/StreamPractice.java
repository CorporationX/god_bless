package stream.practiceone;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPractice {

    public static int sumNumbers(List<Integer> numList) {
        return numList.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxNumber(List<Integer> numList) {
        return numList.stream()
                .max(Comparator.comparingInt(num -> num))
                .orElse(0);
    }

    public static double averNumber(List<Integer> numList) {
        return numList.stream().
                mapToInt(Integer::intValue).
                average().
                orElse(0);

    }

    public static long specificLetter(List<String> strings, String letter) {
        return strings.stream()
                .filter(str -> str.startsWith(letter))
                .count();
    }

    public static List<String> filterLines(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> listSort(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> listCondition(List<String> strings, Predicate<String> condition) {
        return strings.stream().
                filter(condition).
                collect(Collectors.toList());
    }

    public static int minElemInList(List<Integer> numList, Integer num) {
        return numList.stream()
                .filter((n) -> n > num)
                .min(Comparator.comparingInt(n -> n))
                .orElse(0);
    }

    public static List<Integer> lineToLength(List<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .boxed().collect(Collectors.toList());
    }


}
