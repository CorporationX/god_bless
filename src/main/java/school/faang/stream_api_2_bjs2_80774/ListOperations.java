package school.faang.stream_api_2_bjs2_80774;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> findUniqPairs(Set<Integer> numbers, Integer targetNumber) {
        return numbers.stream()
                .filter(n -> n < targetNumber - n && numbers.contains(targetNumber - n))
                .map(n -> Arrays.asList(n, targetNumber - n))
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream().map(n -> n.getValue()).sorted().toList();
    }

    public static List<String> sortFruits(Character ch, List<String> strings) {
        return strings.stream().filter(s -> s.startsWith(ch.toString())).sorted().toList();
    }

    public static List<String> convertingNumbers(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<String> filteringByAlphabet(List<String> strings, String alphabet) {
        return strings.stream().filter(s -> s.chars()
                        .allMatch(c -> alphabet.indexOf(c) >= 0)).collect(Collectors.toList());
    }
}
