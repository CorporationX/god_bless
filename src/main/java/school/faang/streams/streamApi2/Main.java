package school.faang.streams.streamApi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(findUniquePairsOfNumbers(List.of(6), 12));

        Map<String, String> map = new HashMap<>() {{
            put("Russia", "Moscow");
            put("USA", "Washington");
            put("Germany", "Berlin");
        }};
        System.out.println(sortCountriesAndDisplayTheCapitals(map));

        System.out.println(filterAndSortingStrings(Arrays.asList("apple", "banana", "avocado", "apricot"), 'a'));
    }

    public static Set<List<Integer>> findUniquePairsOfNumbers(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.stream()
                .filter(x -> set.contains(sum - x) && sum - x != x)
                .map(x -> Arrays.asList(x, sum - x))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAndDisplayTheCapitals(Map<String, String> countryWithCapitals) {
        return countryWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortingStrings(List<String> strings, char firstChar) {
        return strings.stream()
                .filter(s -> s.charAt(0) == firstChar)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> conversionToBinarySystem(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortingByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

}
