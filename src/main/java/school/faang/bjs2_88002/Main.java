package school.faang.bjs2_88002;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("ghost", "ghoul", "rifle", "house", "essay",
                "property", "prodigy", "kill all women", "dangerous fist", "smile", "praying", "seapage");

        System.out.println(filterBySymbolAndLength(strList, 'P'));
        System.out.println(filterByAlphabetAndLength(strList, "seapg"));

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.putIfAbsent("Russia", "Moscow");
        countriesAndCapitals.putIfAbsent("France", "Paris");
        countriesAndCapitals.putIfAbsent("Germany", "Berlin");
        countriesAndCapitals.putIfAbsent("Italia", "Rome");
        countriesAndCapitals.putIfAbsent("Japan", "Tokyo");
        countriesAndCapitals.putIfAbsent("United States Of America", "Washington");

        System.out.println(capitalsOfSortedCountries(countriesAndCapitals));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(convertToBinary(numbers));

        Set<Integer> setOfNumbers = new HashSet<>();
        setOfNumbers.add(1);
        setOfNumbers.add(2);
        setOfNumbers.add(3);
        setOfNumbers.add(4);
        setOfNumbers.add(5);
        System.out.println(getPairsOfNumbersEqualToValue(setOfNumbers, 8));
    }

    static List<String> filterBySymbolAndLength(List<String> strings, char character) {
        return strings.stream()
                .filter((str) -> str.startsWith(Character.toString(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    static List<String> filterByAlphabetAndLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    static List<String> capitalsOfSortedCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    static Set<List<Integer>> getPairsOfNumbersEqualToValue(Set<Integer> numbers, int value) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Здесь пусто!");
        }
        return numbers.stream()
                .filter((num) -> (num != value - num) && numbers.contains(value - num))
                .map((num) -> Arrays.asList(num, value - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }
}