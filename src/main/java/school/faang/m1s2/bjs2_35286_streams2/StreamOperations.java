package school.faang.m1s2.bjs2_35286_streams2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findUniquePairs(List<Integer> list, int target) {

        Set<Integer> set = new HashSet<>(list);
        return list.stream()
                .filter(num -> set.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
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
        Set<String> lettersSet = Set.of(alphabet.split(""));
        return list.stream()
                .filter(s -> Arrays.stream(s.split(""))
                        .allMatch(lettersSet::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
