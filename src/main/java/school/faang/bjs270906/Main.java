package school.faang.bjs270906;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> setOfNumbers = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(findPairs(setOfNumbers, 6));

        Map<String, String> countriesAndCapitals = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        System.out.println(sortCapitals(countriesAndCapitals));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        char symbol = 'a';
        System.out.println(filterStrings(fruits, symbol));

        List<Integer> listOfNumbers = List.of(1, 2, 3, 4);
        System.out.println(toBinary(listOfNumbers));

        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(filterAndSortByLength(strings, alphabet));
    }

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(number -> number != sum - number && numbers.contains(sum - number))
                .map(number -> Arrays.asList(number, sum - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> cities) {
        return cities.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
