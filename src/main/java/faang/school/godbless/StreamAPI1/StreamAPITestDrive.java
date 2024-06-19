package faang.school.godbless.StreamAPI1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPITestDrive {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return intListToIntStream(numbers).filter(num -> num % 2 == 0).sum();
    }

    public static int maxElement(List<Integer> numbers) {
        return intListToIntStream(numbers).max().orElse(0);
    }

    public static double averageValue(List<Integer> numbers) {
        return intListToIntStream(numbers).average().orElse(0);
    }

    public static IntStream intListToIntStream(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue);
    }

    public static int numberOfStringsStartsWith(List<String> strings, char first) {
        return (strings.stream().filter(str -> first == str.charAt(0)).toList()).size();
    }

    public static List<String> stringsContains(List<String> strings, String string) {
        return strings.stream().filter(str -> str.contains(string)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted((strOne, strTwo) -> strTwo.length() - strOne.length()).collect(Collectors.toList());
    }

    public static <T> boolean allMatch(List<T> elements, Predicate<T> condition) {
        return elements.stream().allMatch(condition);
    }

    public static int minimumThatBiggerThan(List<Integer> numbers, int number) {
        return intListToIntStream(numbers).filter(num -> num > number).sorted().findFirst().orElse(0);
    }

    public static List<Integer> stringsToTheirLength(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}