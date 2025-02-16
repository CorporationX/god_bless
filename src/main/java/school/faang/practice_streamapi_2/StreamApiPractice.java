package school.faang.practice_streamapi_2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiPractice {
    public static Set<List<Integer>> findPairs(Set<Integer> set, int key) {
        return set.stream()
                .filter(num -> num < key - num && set.contains(key - num))
                .map(num -> List.of(num, key - num))
                .collect(Collectors.toSet());
    }

    public static List<String> capitalSortedCountry(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> stringFilterAndSorted(List<String> list, char symbol) {
        return list.stream()
                .filter(s -> s.indexOf(symbol) == 0)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> converterIntDecToBiString(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<String> stringFilterAlphabetAndSorted(List<String> list, String alphabet) {
        return list.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
