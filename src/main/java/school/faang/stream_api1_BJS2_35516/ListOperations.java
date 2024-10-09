package school.faang.stream_api1_BJS2_35516;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter((item) -> item % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(Comparator.comparingInt(o -> o))
                .orElse(0);
    }

    public static double findAverage(List<Integer> list) {
        return list.stream()
                .map(integer -> (double) integer)
                .reduce(0.0, Double::sum)
                / list.size();
    }

    public static int countStringsStartingWith(List<String> list, char startCharacter) {
        return list.stream()
                .filter(s -> s.charAt(0) == startCharacter)
                .toList().size();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String subString) {
        return list.stream()
                .filter(s -> {
                    boolean containsSubstring = false;
                    for (int i = 0; i < s.length() - subString.length(); i++) {
                        if (s.startsWith(subString, i)) {
                            containsSubstring = true;
                            break;
                        }
                    }
                    return containsSubstring;
                })
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted((o1, o2) -> o1.length() - o2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> condition) {
        return list.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> list, int value) {
        return list.stream()
                .filter(numb -> numb > value)
                .min(Comparator.comparingInt(o -> o))
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }

}