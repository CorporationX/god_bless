package school.faang.streamtraining2;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        List<String> fruits = List.of("avocado", "apple", "banana", "apricot");
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        System.out.println(StreamUtils.uniquePairs(integerList, 7));
        System.out.println(StreamUtils.returnCapitals(countries));
        System.out.println(StreamUtils.filterAndSortList(fruits, 'a'));
        System.out.println(StreamUtils.decimalToBinary(integerList));
        System.out.println(StreamUtils.filterSortToAlphabet(words, alphabet));
    }
}
