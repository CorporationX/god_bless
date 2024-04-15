package faang.school.godbless.practise_stream_API_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamPractise {
    public static void main(String[] args) {

        List<Integer> numbersFirst = Arrays.asList(2, 4, 5, 12, 1, 99, 14);
        List<String> strings = Arrays.asList("apple", "banapna", "oranpge", "apvi", "grape2", "kpaiwi", "pani", "aspton", "gradeap", "hi");


        System.out.println(convertStringsToStringsLength(strings));

        System.out.println(findMinElementMoreNumber(numbersFirst, 7));
    }

    public static int findSumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        return numbers.stream().filter(num -> num % 2 == 0).mapToInt(num -> num).sum();
    }

    public static int findMaxElement(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        return numbers.stream().max(Comparator.comparingInt(num -> num)).orElse(0);
    }

    public static double findAverageValue(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        return numbers.stream().mapToInt(num -> num).average().orElse(0.0);
    }

    public static int findNumberOfLinesStartingWithCharacter(List<String> strings, char symbol) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        return strings.stream().filter(line -> line.startsWith(String.valueOf(symbol))).toList().size();
    }

    public static void findListOfSubstrings(List<String> strings, String substring) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        strings.stream().filter(str -> str.contains(substring)).forEach(System.out::println);
    }

    public static void sortByLength(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        strings.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }

    public static <T> boolean verificationByCondition(List<T> elements, Predicate<T> predicate) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        return elements.stream().allMatch(predicate);
    }

    public static int findMinElementMoreNumber(List<Integer> numbers, int specifiedNumber) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        return numbers.stream().filter(num -> num > specifiedNumber).sorted().findFirst().orElse(0);
    }

    public static List<Integer> convertStringsToStringsLength(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        return strings.stream().map(String::length).toList();
    }
}
