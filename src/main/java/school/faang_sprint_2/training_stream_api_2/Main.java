package school.faang_sprint_2.training_stream_api_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(findUniquePairs(Arrays.asList(1, 2, 3, 4, 5, 6), 7));

        System.out.println(sortCountriesGetCapitals(
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));

        System.out.println(filterAndSort(List.of("apple", "banana", "avocado", "apricot"), 'a'));

        System.out.println(convertToBinary(List.of(1, 2, 3, 4)));

        System.out.println(filterByAlphabetSortByLength(List.of("apple", "banana", "cherry", "date", "fig", "grape")
                , "abcdefghijklmnopqrstuvwxyz"));
    }

    private static List<List<Integer>> findUniquePairs(List<Integer> numbers, int pointNumber) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i + j == pointNumber && i < j)
                        .map(j -> Arrays.asList(i, j)))
                .toList();

    }

    private static List<String> sortCountriesGetCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> filterAndSort(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparing(String::length))
                .toList();

    }

    private static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    private static List<String> filterByAlphabetSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> {
                    for (var letter : alphabet.split("")) {
                        if (string.contains(letter)) {
                            return true;
                        }
                    }
                    return false;
                })
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
