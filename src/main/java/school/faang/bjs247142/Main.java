package school.faang.bjs247142;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        findUniqueNumPairs(List.of(1, 2, 3, 4, 5, 6), 7)
                .forEach(System.out::println);

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("USA", "Washington");
        countriesAndCapitals.put("Germany", "Berlin");
        sortCountriesAndDisplayCapitals(countriesAndCapitals)
                .forEach(System.out::println);

        filteringAndSortingStrings(List.of("apple", "banana", "avocado", "apricot"), 'a')
                .forEach(System.out::println);

        transformIntegersToBits(List.of(1, 2, 3, 4))
                .forEach(System.out::println);

        filterStringsAlphabeticallyAndSortingByLength(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz")
                .forEach(System.out::println);

    }

    private static List<List<Integer>> findUniqueNumPairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> uniquePairs = new HashSet<>();

        return numbers.stream()
                .flatMap(integer -> numbers.stream()
                        .filter(num -> sum - integer == num)
                        .map(num -> List.of(Math.min(num, integer), Math.max(num, integer))))
                .filter(uniquePairs::add)
                .toList();
    }

    private static List<String> sortCountriesAndDisplayCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> filteringAndSortingStrings(List<String> strings, char chr) {
        return strings.stream()
                .filter(string -> string.charAt(0) == chr)
                .sorted()
                .toList();
    }

    private static List<String> transformIntegersToBits(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    private static List<String> filterStringsAlphabeticallyAndSortingByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.chars()
                    .allMatch(ch -> alphabet.indexOf(ch) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
