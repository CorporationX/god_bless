package faang.school.godbless.r_edzie.streams.stream_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5);

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "France", "Paris",
                "Germany", "Berlin"
        );

        List<String> strings = List.of("apple", "banana", "orange", "apricot", "pear");


        System.out.println(pairSumOfNumbers(numbers, 10));
        System.out.println(returnCapitals(countries));
        System.out.println(filterAndSortStrings(strings, 'a'));
    }

    public static Set<List<Integer>> pairSumOfNumbers(List<Integer> numbers, int sum) {
        return numbers
                .stream()
                .flatMap(
                        first -> numbers
                                .stream()
                                .filter(second -> first < second && first + second == sum)
                                .map(second -> Arrays.asList(first, second)))
                .collect(Collectors.toSet());
    }

    public static List<String> returnCapitals(Map<String, String> countryCapital) {
        return countryCapital
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char letter) {
        return strings
                .stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
