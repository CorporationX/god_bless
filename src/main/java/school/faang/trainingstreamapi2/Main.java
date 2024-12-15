package school.faang.trainingstreamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 4, 0, 3, 7);
        int targetNumber = 7;
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
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

        Map<String, String> map = new HashMap<>();
        map.put("Russia", "Moscow");
        map.put("USA", "Washington");
        map.put("Germany", "Berlin");
        System.out.println("Отсортированные по странам столицы : "
                + CollectionOperations.getSortedCapitals(map));
    }
}
