package school.faang.task_47172;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(intNum -> intNum % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int findMax(List<Integer> integerList) {
        return integerList.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double findAverage(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static int countStringsStartingWith(List<String> stringList, char symbol) {
        return stringList.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .toList()
                .size();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(
                string -> string.contains(substring)
        ).toList();
    }

    public static List<String> sortByLength(List<String> unsortedStrings) {
        return unsortedStrings.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> integers, Predicate<Integer> predicate) {
        return integers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> integers, int comparingInt) {
        return integers.stream()
                .sorted(Comparator.naturalOrder())
                .filter(integer -> integer > comparingInt)
                .findFirst()
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
