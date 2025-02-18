package school.faang.streamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        findUniquePairs(Set.of(1, 2, 3, 4, 5, 6), 6);
        findCountriesCapitals(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"));
        sortByLength(List.of("apple", "banana", "avocado", "apricot"), 'a');
        convertToBinaryValue(List.of(1, 2, 3, 4));
        filterByAlphabetAndSortByLength(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz");
    }

    private static List<int[]> findUniquePairs(Set<Integer> nums, int target) {
        return nums.stream()
                .flatMap(i -> nums.stream().filter(j -> i + j == target && i < j)
                        .map(j -> new int[]{i, j}))
                .peek(arr -> System.out.printf("%d : %d%n", arr[0], arr[1]))
                .collect(Collectors.toList());
    }

    private static List<String> findCountriesCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .peek(System.out::println)
                .toList();
    }

    private static List<String> sortByLength(List<String> words, char target) {
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(target)))
                .sorted(Comparator.comparingInt(String::length))
                .peek(System.out::println)
                .toList();
    }

    private static List<String> convertToBinaryValue(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .peek(System.out::println)
                .toList();
    }

    private static List<String> filterByAlphabetAndSortByLength(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> word.chars().allMatch(letter -> alphabet.indexOf(letter) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .peek(System.out::println)
                .toList();
    }
}
