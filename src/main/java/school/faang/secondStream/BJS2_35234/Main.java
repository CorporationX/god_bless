package school.faang.secondStream.BJS2_35234;

import java.util.List;
import java.util.Map;

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

        System.out.println(StreamOperations.findUniquePairs(numbers, 7));
        System.out.println(StreamOperations.getCapitalCities(countries));
        System.out.println(StreamOperations.filterList(words, 'a'));
        System.out.println(StreamOperations.convertingToBinaryFormat(numbers));
        System.out.println(StreamOperations.filterAndSort(strings, alphabet));


    }
}
