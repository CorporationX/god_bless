package streamApi.task1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {
    public static int evenSum(List<Integer> numbers) {
        return numbers.stream()
                .filter((number) -> number % 2 == 0)
                .reduce(0, (number1, number2) -> number1 + number2);

    }

    public static Optional<Integer> max(List<Integer> numbers) {
        return numbers.stream()
                .max((numbers1, numbers2) -> numbers1 - numbers2);
    }

    public static OptionalDouble average(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(number -> number)
                .average();
    }

    public static long countStringsWithStartingCharacter(char start, List<String> strings) {
        return strings.stream()
                .filter((string) -> string.startsWith(String.valueOf(start)))
                .count();

    }

    public static List<String> filterStringsContainingSubstring(String substring, List<String> strings) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .collect(Collectors.toList());

    }

    public static void sortStringsByLength(List<String> strings) {
        strings.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .forEach(str -> System.out.println(str));
    }

    public static boolean allMatch(List<String> strings, Predicate<String> condition) {
        return strings.stream().allMatch(condition);
    }

    public static Optional<Integer> findSmallestElementGreaterThan(int number, List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > number)
                .min((num1, num2) -> num1 - num2);

    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(str -> str.length())
                .toList();
    }
}
