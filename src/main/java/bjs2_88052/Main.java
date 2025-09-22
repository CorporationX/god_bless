package bjs2_88052;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Пары с суммой 6: " + StreamTasks.findPairs(numbers, 6));


        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println("Столицы по алфавиту стран: " + StreamTasks.getSortedCapitals(countries));

        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println("Строки на 'a' отсортированные: " + StreamTasks.filterAndSort(words, 'a'));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println("Двоичные числа: " + StreamTasks.convertToBinary(nums));

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Фильтрованные строки: " + StreamTasks.filterAndSortByLength(fruits, alphabet));
    }
}