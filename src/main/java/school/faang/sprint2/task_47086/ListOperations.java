package school.faang.sprint2.task_47086;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> integerList) {
        return integerList.stream().filter(integer -> integer % 2 == 0).reduce(Integer::sum).orElse(0);
    }

    public static int findMax(List<Integer> integerList) {
        return integerList.stream().max(Integer::compareTo).orElseThrow();
    }

    public static double findAverage(List<Integer> integerList) {
        return (double) integerList.stream().reduce(Integer::sum).orElseThrow()
                / integerList.stream().filter(Objects::nonNull).count();
    }

    public static int countStringsStartingWith(List<String> stringList, char character) {
        return (int) stringList.stream().filter(s -> s.startsWith(String.valueOf(character))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringList, String subString) {
        return stringList.stream().filter(string -> string.contains(subString)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> integerList, Predicate<Integer> predicate) {
        return integerList.stream().filter(predicate.negate()).findAny().isEmpty();
    }

    public static int findMinGreaterThan(List<Integer> integerList, int threshold) {
        return integerList.stream().filter(integer -> integer > threshold).sorted().findFirst().orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream().map(String::length).collect(Collectors.toList());
    }
}
