package faang.school.godbless.domain.task_Srteam1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


    }

    public static int sum(List<Integer> integerList) {
        return integerList.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> integerList) {
        return integerList.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("failed to find maximum"));
    }

    public static double avr(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(e -> e)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("could not find the average value"));
    }

    public static long countString(List<String> stringList, Character character) {
        return stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(character)))
                .count();
    }

    public static List<String> filterString(List<String> stringList, String string) {
        return stringList.stream()
                .filter(s -> s.contains(string))
                .collect(Collectors.toList());
    }

    public static List<String> sortString(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static boolean booleanList(List<String> stringList) {
        return stringList.stream()
                .allMatch(s -> s.length() >= 2);
    }

    public static int findMinValueList(List<Integer> integerList, Integer number) {
        return integerList.stream()
                .filter(s -> s > number)
                .min(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("no more elements " + number));
    }

    public static List<Integer> mapStringToLength(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
