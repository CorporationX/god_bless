package faang.school.godbless.BJS2_23033;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static int evenSum(List<Integer> nums) {
        return nums.stream().filter(num -> num % 2 == 0).reduce(0, (sum, num) -> sum + num);
    }

    public static int max(List<Integer> nums) {
        return nums.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
    }

    public static double avg(List<Integer> nums) {
        return (double) nums.stream().reduce(0, Integer::sum) / nums.size();
    }

    public static long countStringsStartWithChars(List<String> strings, List<Character> chars) {
        return strings.stream().filter(string ->
                chars.stream().anyMatch(character -> string.startsWith(character.toString()))).count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream().filter(string ->
                string.toLowerCase().contains(substring.toLowerCase())).collect(Collectors.toList());
    }

    public static List<String> sortedByLength(List<String> strings) {
        return strings.stream().sorted((stringOne, stringTwo) ->
                stringOne.length() - stringTwo.length()).collect(Collectors.toList());
    }

    public static <T> boolean allIsCorrect(List<T> elements, Predicate<T> predicate) {
        return elements.stream().allMatch(predicate);
    }

    public static int minAfterValue(List<Integer> nums, int value) {
        return nums.stream().filter(num -> num > value).min(Integer::compareTo).orElse(value);
    }

    public static List<Integer> mapToLength(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println(evenSum(nums));
        System.out.println(max(nums));
        System.out.println(avg(nums));
        System.out.println(countStringsStartWithChars(List.of("hi", "lol", "wow"), List.of('h', 'l')));
        filterBySubstring(List.of("Hello", "begin", "START"), "ta").forEach(System.out::println);
        sortedByLength(List.of("aaa", "a", "aa")).forEach(System.out::println);
        System.out.println(allIsCorrect(List.of(0, 1, 2, 3, 4), num -> num >= 0));
        System.out.println(minAfterValue(List.of(1, 2, 3, 4, 5), 3));
        System.out.println(mapToLength(List.of("hi", "lol", "wowww")));
    }
}



