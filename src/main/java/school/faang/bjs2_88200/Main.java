package school.faang.bjs2_88200;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> setNumbers = Set.of(1, 2, 3, 4, 5, 6);

        Map<String, String> mapCountry = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        List<String> listFruits = List.of("apple", "banana", "avocado", "apricot");

        List<Integer> listNumbers = List.of(1, 2, 3, 4);

        List<String> listStrings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Уникальные пары чисел: " + CollectionOperations.findPairsWithSum(setNumbers, 6));
        System.out.println("Столицы стран: " + CollectionOperations.getCapitalsSortedByCountry(mapCountry));
        System.out.println("Фрукты: " + CollectionOperations.filterAndSortByLength(listFruits, 'a'));
        System.out.println("Двоичное представление чисел: " + CollectionOperations.convertToBinaryStrings(listNumbers));
        System.out.println("Отфильтрованный список: "
                + CollectionOperations.filterAndSortByAlphabet(listStrings, alphabet));
    }
}
