package school.faang.streamapi_2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 * Дата: 23.09.2025
 */

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));
        int target = 6;
        Set<List<Integer>> pairs = UniquePairs.findPairs(nums, target);
        System.out.println("Уникальные пары:");
        pairs.forEach(pair -> log.info(String.valueOf(pair)));


        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        List<String> sortedCapitals = SortCountries.getSortedCapitals(countries);
        System.out.println("\nОтсортированные столицы по странам:");
        System.out.println(sortedCapitals);

        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        char ch = 'a';
        List<String> filteredSortedStrings = FilterAndSortStrings.filterAndSort(strings, ch);
        System.out.println("\nОтфильтрованные и отсортированные строки:");
        System.out.println(filteredSortedStrings);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> binaryNumbers = ConvertToBinary.convertToBinary(numbers);
        System.out.println("\nДвоичные числа:");
        System.out.println(binaryNumbers);

        List<String> stringsForFilter = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredSortedAlphabet = FilterAndSortAlphabet.filterAndSortByLength(stringsForFilter, alphabet);
        System.out.println("\nОтфильтрованные и отсортированные по алфавиту:");
        System.out.println(filteredSortedAlphabet);
    }
}