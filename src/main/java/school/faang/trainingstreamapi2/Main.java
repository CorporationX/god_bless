package school.faang.trainingstreamapi2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 1, 4, 0, 3, 7);
        int targetNumber = 7;
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        char symbol = 'a';
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Уникальные пары чисел: "
                + CollectionOperations.findUniqueNumberPairs(numbers, targetNumber));
        System.out.println("Фильтрация и сортировка строк: "
                + CollectionOperations.filterStringsStartingWith(strings, symbol));
        System.out.println("Преобразование чисел в двоичный формат: "
                + CollectionOperations.convertToBinary(numbers));
        System.out.println("Фильтрация строк по алфавиту и сортировка по длине: "
                + CollectionOperations.filterAndSortByLength(strings, alphabet));

        Map<String, String> map = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println("Отсортированные по странам столицы : "
                + CollectionOperations.getSortedCapitals(map));
    }
}
