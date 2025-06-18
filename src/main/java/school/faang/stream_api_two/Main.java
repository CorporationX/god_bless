package school.faang.stream_api_two;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(uniquePairsWhoseSumIsEqualToNumber(Set.of(1, 2, 3, 4, 5, 6), 6));
        System.out.println(countriesAndDisplayCapitals(Map.of("Russia", "Moscow", "USA", "Washington",
                "Germany", "Berlin")));
        System.out.println(filteringAndSortingRows(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(convertingNumbersToBinaryFormat(List.of(1, 2, 3, 4)));
        System.out.println(filterStringsAlphabeticallyAndSortByLength(List.of("apple", "banana", "cherry",
                "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"));
    }

    public static Set<List<Integer>> uniquePairsWhoseSumIsEqualToNumber(Set<Integer> setInt, int targetInt) {
        return setInt.stream()
                .filter(n -> targetInt - n != n && targetInt - n != 0)
                .map(n -> Arrays.asList(n, targetInt - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> countriesAndDisplayCapitals(Map<String, String> countriesCapitals) {
        return countriesCapitals.keySet().stream()
                .map(countriesCapitals::get)
                .sorted(String::compareTo)
                .toList();
    }

    public static List<String> filteringAndSortingRows(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.indexOf(ch) == 0)
                .sorted(String::compareTo)
                .toList();
    }

    public static List<String> convertingNumbersToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterStringsAlphabeticallyAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}