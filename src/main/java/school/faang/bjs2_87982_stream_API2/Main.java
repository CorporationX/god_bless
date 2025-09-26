package school.faang.bjs2_87982_stream_API2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(Methods.findUniqueNumbersPairWithSum(numbers, 6));

        System.out.println("Задача 2");
        Map<String, String> countriesAndCities = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println(Methods.getCapitalsSortedByCountry(countriesAndCities));

        System.out.println("Задача 3");
        List<String> words = List.of("apple", "banana", "avocado", "apricot");
        char c = 'a';
        System.out.println(Methods.filterStringsByStartingCharAndSortByLength(words, c));

        System.out.println("Задача 4");
        List<Integer> intNumbers = List.of(1, 2, 3, 4);
        System.out.println(Methods.toBinaryStringList(intNumbers));

        System.out.println("Задача 5");
        List<String> list = List.of("apple", "banana", "2cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Methods.filterByAlphabetAndLength(list, alphabet));
    }
}