package school.faang.streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Поиск уникальных пар чисел
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 6;
        List<int[]> pairs = Filters.findUniquePairs(nums, target);
        System.out.println("Уникальные пары:");
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        // Сортировка стран и вывод столиц
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        List<String> capitals = Filters.sortCountries(countries);
        System.out.println("\nСтолицы отсортированных стран:");
        System.out.println(capitals);

        // Фильтрация и сортировка строк
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char ch = 'a';
        List<String> filteredStrings = Filters.filterAndSortStrings(strings, ch);
        System.out.println("\nОтфильтрованные и отсортированные строки:");
        System.out.println(filteredStrings);

        // Преобразование чисел в двоичный формат
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> binaryNumbers = Filters.toBinary(numbers);
        System.out.println("\nЧисла в двоичном формате:");
        System.out.println(binaryNumbers);

        // Фильтрация строк по алфавиту и сортировка по длине
        List<String> strings2 = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredAndSortedStrings = Filters.filterAndSortByAlphabet(strings2, alphabet);
        System.out.println("\nОтфильтрованные и отсортированные строки по алфавиту:");
        System.out.println(filteredAndSortedStrings);
    }
}
