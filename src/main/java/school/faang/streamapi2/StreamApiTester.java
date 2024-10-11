package school.faang.streamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiTester {
    public static Set<List<Integer>> findPairs(List<Integer> list, int sum) {
        Set<Integer> set = new HashSet<>(list);
        return list.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> countriesMap) {
        return countriesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterByChar(List<String> list, char ch) {
        return list.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabet(List<String> list, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return list.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
