package school.faang.m1s2.bjs2_35286_streams2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StreamOperations {

    public static Set<List<Integer>> findUniquePairs(List<Integer> list, int target) {
        return list.stream()
                .flatMap(i -> list.stream()
                        .filter(j -> i + j == target)
                        .map(j -> asList(Math.min(i, j), Math.max(i, j)))
                )
                .collect(Collectors.toSet());
    }

    public static List<String> showCapitals(Map<String, String> countriesToCapitals) {
        return countriesToCapitals.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getKey()))
                .map(entry -> entry.getValue())
                .toList();
    }

    public static List<String> sortByFilterLength(List<String> list, char letter) {
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertIntToBinary(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterSortByAlphabet(List<String> list, String alphabet) {
        return list.stream()
                .filter(s -> s.length() ==
                        Arrays.stream(s.split(""))
                                .filter(alphabet::contains)
                                .count())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
