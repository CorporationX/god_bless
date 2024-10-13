package school.faang.sprint_2.StreamApi2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>(numbers);

        pairs = numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(list -> Collections.sort(list))
                .collect(Collectors.toSet());
        return pairs;
    }

    public static List<String> sortCity(Map<String, String> countryMap) {
        Set<Map.Entry<String, String>> setCountry = countryMap.entrySet();
        return setCountry.stream().sorted(Map.Entry.comparingByKey()).map(entry -> entry.getValue()).toList();
    }

    public static List<String> sortString(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(ch)) && !string.isEmpty())
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(num -> Integer.toBinaryString(num)).toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alfavit) {
        String regex = "^[" + alfavit + "]+$";
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

}
