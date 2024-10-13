package school.faang.BJS2_35234;

import java.util.List;
import java.util.Map;

import static school.faang.BJS2_35234.StreamOperations.convertingToBinaryFormat;
import static school.faang.BJS2_35234.StreamOperations.filterAndSort;
import static school.faang.BJS2_35234.StreamOperations.filterList;
import static school.faang.BJS2_35234.StreamOperations.findUniquePairs;
import static school.faang.BJS2_35234.StreamOperations.getCapitalCities;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<String, String> countries = Map.of(
                "Russia", "Moskow",
                "USA", "Washington",
                "Germany", "Berlin");

        List<String> words = List.of("apple", "banana", "avocado", "apricot");

        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(findUniquePairs(numbers, 7));
        System.out.println(getCapitalCities(countries));
        System.out.println(filterList(words, 'a'));
        System.out.println(convertingToBinaryFormat(numbers));
        System.out.println(filterAndSort(strings, alphabet));


    }
}
