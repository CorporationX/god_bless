package school.faang.BJS235210;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 45);
        Map<String, String> countryCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin",
                "Kazakhstan", "Astana");
        List<String> fruits = List.of("apple", "banana", "avocado", "apricot", "papaya", "peach", "pear", "pineapple");
        String letter = "p";
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(ListOperations.getUniquePair(numbers, 7));
        System.out.println(ListOperations.getCapitalsSorted(countryCapitals));
        System.out.println(ListOperations.getSortedFruitsByLetter(fruits, letter));
        System.out.println(ListOperations.getBinaryDigit(numbers));
        System.out.println(ListOperations.getFilteredAndSortedByLength(words, alphabet));
    }

}
