package school.faang.сollection__stream_api__optional.bjs2_87908;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OperationsWithStream {
    public static Set<List<Integer>> findUniquePairs(Set<Integer> setNumbers, int sum) {
        return setNumbers.stream()
                .filter(x -> setNumbers.contains(sum - x) && x < sum - x)
                .map(x -> Arrays.asList(x, sum - x))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> list, char simbol) {
        return list.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == simbol)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> getNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> list, String alphabet) {
        Set<Character> allowedChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return list.stream()
                .filter(s -> s.chars().mapToObj(c -> (char) c)
                        .allMatch(allowedChars::contains))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }
}
