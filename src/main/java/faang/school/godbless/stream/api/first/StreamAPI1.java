package faang.school.godbless.stream.api.first;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI1 {
    public static int sum(List<Integer> numbers) {
        Stream<Integer> integerStream = numbers.stream().filter(number -> number % 2 == 0);
        return integerStream.mapToInt(Integer::intValue).sum();
    }

    public static int max(List<Integer> numbers) {
        Stream<Integer> integerStream = numbers.stream();
        return integerStream.mapToInt(Integer::intValue).max().orElse(0);
    }

    public static double avg(List<Integer> numbers) {
        Stream<Integer> integerStream = numbers.stream();
        return integerStream.mapToInt(Integer::intValue).average().orElse(0);
    }

    public static long numberOfLines(List<String> lines, char symbol) {
        Stream<String> stringStream = lines.stream();
        return stringStream.filter(str -> str.startsWith(String.valueOf(symbol))).count();
    }

    public static List<String> filter(List<String> stringList, String line) {
        return stringList.stream().filter(s -> s.contains(line)).toList();
    }

    public static List<String> sorted(List<String> stringList) {
        return stringList.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static <T> boolean check(List<T> integerList, Predicate<T> predicate) {
        return integerList.stream().allMatch(predicate);
    }

    public static int search(List<Integer> list, int number) {
        Stream<Integer> integerStream = list.stream().filter(i -> i > number);
        return integerStream.mapToInt(Integer::intValue).min().orElse(0);
    }

    public static List<Integer> transformation(List<String> stringList) {
        return stringList.stream().map(String::length).collect(Collectors.toList());
    }

}
