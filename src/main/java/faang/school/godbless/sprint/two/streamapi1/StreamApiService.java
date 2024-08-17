package faang.school.godbless.sprint.two.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StreamApiService {

    public static int getSumOfEvenNumbersInList(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (accumulator, element) -> {
                    if (element % 2 == 0) {
                        return accumulator + element;
                    }
                    return accumulator;
                });
    }

    public static int findMaxElementInList(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new NoSuchElementException(Constants.EMPTY_LIST_EXCEPTION);
        }
        return numbers.stream()
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getMax();
    }

    public static double findAverageNumberInList(List<Integer> numbers) {
        return numbers.stream().mapToDouble(d -> d).average().orElse(0.0);
    }

    public static long findLinesAmountFromStringsStartsWith(List<String> strings, char startsWith) {
        return strings.stream().filter(l -> l.startsWith(String.valueOf(startsWith))).count();
    }

    public static List<String> findSubstringsInList(List<String> strings, String subString) {
        return strings.stream().filter(l -> l.contains(subString)).toList();
    }

    public static List<String> sortListOfStringsByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean checkIfElementsGreaterThan(List<Integer> numbers, int element) {
        return numbers.stream().allMatch(i -> i > element);
    }

    public static int findMinElementGreaterThan(List<Integer> numbers, int markerNumber) {
        return numbers.stream()
                .filter(n -> n > markerNumber)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> convertStringsToTheirLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
