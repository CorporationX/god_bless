package school.faang.task_47171;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<List<Integer>> uniquePairsWithSum = findUniquePairs(numbers, 7);
        uniquePairsWithSum.forEach(System.out::println);

        /*------------------------------------------------------------------------------------------------------*/
        Map<String, String> countryCapital = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        List<String> sortedCountries = countriesSorting(countryCapital);
        sortedCountries.forEach(System.out::println);

        /*------------------------------------------------------------------------------------------------------*/
        List<String> availableFruits = List.of("apple", "banana", "avocado", "apricot");
        List<String> filteredFruits = filterString(availableFruits, "a");
        filteredFruits.forEach(System.out::println);

        /*------------------------------------------------------------------------------------------------------*/
        List<Integer> integerValues = List.of(1, 2, 3, 4);
        List<String> stringRepresentationOfIntegers = convertIntegerListToStringList(integerValues);
        stringRepresentationOfIntegers.forEach(System.out::println);

        /*------------------------------------------------------------------------------------------------------*/
        List<String> fruitNames = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredAndSortedStrings = filterAndSortStringsByLength(fruitNames, alphabet);
        filteredAndSortedStrings.forEach(System.out::println);


    }

    public static List<List<Integer>> findUniquePairs(List<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i + j == target && i < j)
                        .map(j -> Arrays.asList(i, j))).distinct().collect(Collectors.toList());
    }


    public static List<String> countriesSorting(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterString(List<String> str, String ch) {
        return str.stream()
                .filter(s -> s.startsWith(ch))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertIntegerListToStringList(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStringsByLength(List<String> fruitList, String alphabet) {
        return fruitList.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

    }

}
