package school.faang.bjs2_88014;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> setNumbers = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> countriesWithCities = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        List<Integer> listNumbers = List.of(1, 2, 3, 4);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        //Найдите уникальные пары чисел
        System.out.println(Operations.findUniquePairs(setNumbers, 7));
        //Отсортируйте страны и выведите столицы
        System.out.println(Operations.sortCountriesPrintCities(countriesWithCities));
        //Фильтрация и сортировка строк
        System.out.println(Operations.filterAndSortStrings(strings, 'a'));
        //Преобразование чисел в двоичный формат
        System.out.println(Operations.convertNumbersToBinary(listNumbers));
        //Фильтрация строк по алфавиту и сортировка по длине
        System.out.println(Operations.filterAndSortByLength(strings, alphabet));
    }
}
