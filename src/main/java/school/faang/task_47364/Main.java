package school.faang.task_47364;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int targetSum = 8;
        Set<List<Integer>> pairs = Operations.findPairsToSum(numbers, targetSum);
        System.out.println("Числа: " + numbers);
        System.out.println("Целевая сумма: " + targetSum);
        System.out.println("Уникальные пары чисел: " + pairs);
        System.out.println();

        Map<String, String> countriesAndCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin",
                "France", "Paris"
        );
        List<String> capitals = Operations.getSortedCapitals(countriesAndCapitals);
        System.out.println("Страны и столицы: " + countriesAndCapitals);
        System.out.println("Отсортированные столицы: " + capitals);
        System.out.println();

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot", "blueberry");
        char startChar = 'a';
        List<String> filteredAndSortedStrings = Operations.sortedStrings(strings, startChar);
        System.out.println("Строки: " + strings);
        System.out.println("Фильтрация и сортировка по символу '" + startChar + "': " + filteredAndSortedStrings);
        System.out.println();

        List<Integer> numbersToConvert = Arrays.asList(1, 2, 3, 4, 5, 10, 15);
        List<String> binaryStrings = Operations.conversionToBinaryFormat(numbersToConvert);
        System.out.println("Числа: " + numbersToConvert);
        System.out.println("Двоичное представление чисел: " + binaryStrings);
        System.out.println();

        List<String> alphabetStrings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi");
        List<String> filteredStrings = Operations.filterAndSortedStrings(alphabetStrings);
        System.out.println("Строки: " + alphabetStrings);
        System.out.println("Фильтрация и сортировка по длине: " + filteredStrings);
    }
}
