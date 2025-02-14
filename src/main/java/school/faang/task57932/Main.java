package school.faang.task57932;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> integers = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(integers);
        int target = 6;
        System.out.println(findPairs(integers, target));
        System.out.println();

        Map<String, String> countryCapital = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println(findCapitals(countryCapital));
        System.out.println();

        List<String> fruct = List.of("apple", "banana", "avocado", "apricot");
        char symbol = 'a';
        System.out.println(filtSortStr(fruct, symbol));
        System.out.println();

        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> binaryStrings = convertToBinary(numbers);
        System.out.println(binaryStrings);
        System.out.println();

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(sortAlphabit(words, alphabet));
        System.out.println();

    }

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num < sum - num && numbers.contains(sum - num))
                .map(num -> List.of(num, sum - num))
                .collect(Collectors.toSet());
    }

    public static List<String> findCapitals(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream()
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> filtSortStr(List<String> fruct, char symbol) {
        return fruct.stream()
                .filter((string -> string.charAt(0) == symbol))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    private static List<String> sortAlphabit(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> word.chars().allMatch(ch -> alphabet.indexOf(ch) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}


