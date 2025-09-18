package school.faang.bjs2_88025;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println("Уникальная пара чисел: " + ListFunctions.findPairs(numbers, 6));

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin",
                "France", "Paris",
                "Japan", "Tokyo");
        System.out.println("Отсортированные столицы: " + ListFunctions.getSortedCapitals(countries));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        System.out.println("Фильтрация по 'a': " + ListFunctions.filterAndSort(fruits, 'a'));

        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println("Двоичное представление: " + ListFunctions.convertToBinary(nums));

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Фильтрация по алфавиту: " + ListFunctions.filterAndSortByLength(words, alphabet));
    }
}