package school.faang.BJS2_35260;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Найдите уникальные пары чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int target = 7;
        List<List<Integer>> pairs = ListOperations.findUniquePairs(numbers, target);
        System.out.println("Уникальные пары: " + pairs.stream()
                .map(pair -> "(" + pair.get(0) + ", " + pair.get(1) + ")")
                .collect(Collectors.joining(", ")));

        // Отсортируйте страны и выведите столицы
        Map<String, String> countryCapitalMap = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        List<String> capitals = ListOperations.sortCountriesAndReturnCapitals(countryCapitalMap);
        System.out.println("Столицы: " + capitals);

        // Фильтрация и сортировка строк
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';
        List<String> filteredSortedStrings = ListOperations.filterAndSortStrings(strings, startChar);
        System.out.println("Отфильтрованные и отсортированные строки: " + filteredSortedStrings);

        // Преобразование чисел в двоичный формат
        List<Integer> numbersToConvert = Arrays.asList(1, 2, 3, 4);
        List<String> binaryStrings = ListOperations.convertNumbersToBinary(numbersToConvert);
        System.out.println("Двоичные строки: " + binaryStrings);

        // Фильтрация строк по алфавиту и сортировка по длине
        List<String> stringsToFilter = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredByAlphabet = ListOperations.filterAndSortByAlphabet(stringsToFilter, alphabet);
        System.out.println("Отфильтрованные и отсортированные по длине строки: " + filteredByAlphabet);
    }
}
