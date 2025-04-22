package school.faang.streamapi2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int targetSum = 6;

        Set<String> pairs = ListOperations.findPairs(numbers, targetSum);
        System.out.printf("1. Уникальные пары с суммой %s : %s%n", targetSum, pairs);


        Map<String, String> countries =
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        System.out.printf("2. Отсортированные столицы: %s%n", ListOperations.getSortedCapitals(countries));

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.printf("3. Отфильтрованные и отсортированные строки: %s%n",
                ListOperations.filterAndSortByLength(strings, 'a'));

        List<Integer> listNumbers = Arrays.asList(1, 2, 3, 4);
        System.out.printf("4. Двоичное представление чисел: %s%n",
                ListOperations.convertToBinary(listNumbers));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.printf("5. Строки по алфавиту и длине: %s%n",
                ListOperations.filterAndSortByAlphabet(words, alphabet));
    }
}