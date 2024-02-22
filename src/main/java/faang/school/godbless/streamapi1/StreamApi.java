package faang.school.godbless.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamApi {
    public static Optional<Integer> sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> (num & 1) == 0).reduce(Integer::sum);
    }

    public static Optional<Integer> findMaxNumber(List<Integer> numbers) {
        return numbers.stream().max(Comparator.naturalOrder());
    }

    public static Optional<Integer> findAvgNumber(List<Integer> numbers) {
        return numbers.stream().reduce(Integer::sum);
    }

    public static int countStringsWithStartingCharacter(List<String> strings, char symbol) {
        return (int) strings.stream().filter(string -> !string.isEmpty() && string.toLowerCase().charAt(0) == symbol).count();
    }

    public static List<String>  filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(string -> string.contains(substring)).toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean checkingListForACondition(List<String> strings, String condition) {
        return strings.stream().allMatch(string -> string.contains(condition));
    }

    public static Optional<Integer> findSmallestElementGreaterThan(List<Integer> numbers, int numberCondition) {
        return numbers.stream().filter(number -> number>numberCondition).min(Comparator.comparing(num -> num > numberCondition + 1));
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }

}
