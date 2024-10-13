package school.faang.streamapi2;

import java.util.ArrayList;
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

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int target = 7;

        List<int[]> uniquePairs = findUniquePairs(numbers, target);
        Map<String, String> countryAndCapital = new HashMap<>();
        List<String> listOfFruits = List.of("apple", "banana", "avocado", "apricot");
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        countryAndCapital.put("Russia", "Moscow");
        countryAndCapital.put("USA", "Washington");
        countryAndCapital.put("Germany", "Berlin");

        // Выводим результат
        uniquePairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
        System.out.println(findCapitals(countryAndCapital));
        List<String> filteredListOfFruits = filterAndSortStrings(listOfFruits);
        System.out.println(filteredListOfFruits);
        List<String> binaryStrings = convertToBinary(numbers);
        System.out.println(binaryStrings);
        System.out.println(filterAndSortByAlphabetAndSize(strings));

    }

    public static List<int[]> findUniquePairs(List<Integer> numbers, int target) {
        Set<Integer> seen = new HashSet<>();

        Set<int[]> result = numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a + b == target && !seen.contains(a) && !seen.contains(b))
                        .map(b -> {
                            seen.add(a);
                            seen.add(b);
                            return new int[]{a, b};
                        }))
                .collect(Collectors.toSet());

        return new ArrayList<>(result);
    }

    public static List<String> findCapitals(Map<String, String> mapWithCountries) {
        return mapWithCountries.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char character) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings) {
        char filterChar = 'a';
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(filterChar)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByAlphabetAndSize(List<String> strings) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return strings.stream()
                .filter(str -> str.chars().allMatch(ch -> alphabet.indexOf(Character.toLowerCase(ch)) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}

