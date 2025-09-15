package school.faang.bjs2_88080;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println("1. Пары чисел:");
        findUniquePairsThatAddUpTo(numbers, 7).forEach(System.out::println);

        Map<String, String> countries = Map.of("Russia", "Moscow", "USA", "Washington",
                "German", "Berlin");
        System.out.println("2. Отсортированные столицы:");
        sortCountriesAndPrintCapitals(countries).forEach(System.out::println);

        List<String> words = List.of("apple", "banana", "avocado", "apricot");
        System.out.println("3. Отсортированные строки по длине:");
        filterStartingWithAndSortByLength(words, 'a').forEach(System.out::println);

        List<Integer> otherNumbers = List.of(1, 2, 3, 4);
        System.out.println("4. Двоичные числа:");
        convertNumberToBinary(otherNumbers).forEach(System.out::println);

        List<String> otherWords = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "^[a-zA-Z]*$";
        System.out.println("5. Отсортированные строки по длине:");
        filterByAlphabetAndSortByLength(otherWords, alphabet).forEach(System.out::println);
    }

    public static Set<List<Integer>> findUniquePairsThatAddUpTo(Set<Integer> numbers, int value) {
        return numbers.stream()
                .filter(number -> number != value - number && numbers.contains(value - number))
                .map(number -> Arrays.asList(number, value - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());

    }

    public static List<String> sortCountriesAndPrintCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStartingWithAndSortByLength(List<String> words, char symbol) {
        return words.stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertNumberToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> words, String alphabet) {
        return words.stream()
                .filter(string -> string.matches(alphabet))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
