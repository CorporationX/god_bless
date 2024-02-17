package faang.school.godbless.streamapifirst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 7, 9, 6);
        List<String> strings = List.of("join", "kldfgl", "erjghjerkhn", "ewferh", "Java");
        System.out.println("Sum of even: " + sumOfEven(numbers));
        System.out.println("Max number: " + max(numbers));
        System.out.println("Average: " + average(numbers));
        System.out.println("Starts with 'j': " + countStringsWithStartingCharacter(strings, 'j'));
        List<String> strings2 = new ArrayList<>() {{
            add("klerklgklerjsubstringldrghlker");
            add("rnghjklernjkghnkerjhn");
            add("nrghjkerhgjkhernjkghne");
            add("substring");
            add("lkerjgjk");
            add("ergjklherjkgsubstring");
        }};
        System.out.println(strings2);
        strings2 = filterStringsContainingSubstring(strings2, "substring");
        System.out.println(strings2);
        strings2 = sortStringsByLength(strings2);
        System.out.println(strings2);
        System.out.println(allMatch(strings, string -> string.length() > 10));
        System.out.println(findSmallestElementGreaterThan(numbers, 7));
        System.out.println(convertStringsToLengths(strings2));
    }

    public static int sumOfEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int max(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0D);
    }

    public static long countStringsWithStartingCharacter(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(str -> str.contains(substring)).collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static boolean allMatch(List<String> strings, Predicate<String> condition) {
        return strings.stream().allMatch(condition);
    }

    public static int findSmallestElementGreaterThan(List<Integer> nums, int num) {
        return nums.stream().filter(n -> n > num).min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}
