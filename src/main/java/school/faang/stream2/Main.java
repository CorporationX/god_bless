package school.faang.stream2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(findUniquePairs(numbers, 6));

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("USA", "Washington");
        countriesAndCapitals.put("Germany", "Berlin");
        System.out.println(sortCountry(countriesAndCapitals));

        List<String> input = Arrays.asList("apple", "avocado", "apricot", "banana", "cherry", "date", "fig", "grape");
        System.out.println(strFilterAndSort(input, 'a'));


        System.out.println(convertToBinary(numbers.stream().toList()));

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(filterAndSortStr(input, alphabet));

    }

    private static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        Set<List<Integer>> result = new HashSet<>();
        numbers.stream()
                .filter(num -> (sum - num > num && numbers.contains(sum - num)))
                .map(num -> List.of(num, sum - num))
                .forEach(result::add);
        return result;
    }

    private static Set<String> sortCountry(Map<String, String> countries) {
        Set<String> result = countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
        return result;
    }

    private static List<String> strFilterAndSort(List<String> strings, char character) {
        List<String> result;
        result = strings.stream()
                .filter(string -> string.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        return result;
    }

    private static List<String> convertToBinary(List<Integer> numbers) {
        List<String> result = numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
        return result;
    }

    private static List<String> filterAndSortStr(List<String> strings, String alphabet) {
        String regex = "^[(" + alphabet + "]+$";
        List<String> result = strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        return result;
    }

}
