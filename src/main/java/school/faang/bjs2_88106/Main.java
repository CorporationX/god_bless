package school.faang.bjs2_88106;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 6;
        Set<List<Integer>> result1 = ListOperations.findPairs(nums, target);
        System.out.println("Уникальные пары:");
        result1.forEach(System.out::println);

        Map<String, String> capitals = new HashMap<>();
        capitals.put("Russia", "Moscow");
        capitals.put("USA", "Washington");
        capitals.put("Germany", "Berlin");
        List<String> sortedCapitals = ListOperations.sortCapitals(capitals);
        System.out.println("\nСтолица каждой страны (алфавитный порядок стран):");
        System.out.println(sortedCapitals);

        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        char firstLetter = 'a';
        List<String> filteredFruits = ListOperations.filterAndSort(fruits, firstLetter);
        System.out.println("\nОтфильтрованные фрукты, начинающиеся на '" +
                firstLetter + "', отсортированные по длине:");
        System.out.println(filteredFruits);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> binaryNumbers = ListOperations.convertToBinary(numbers);
        System.out.println("\nСписок чисел в двоичном представлении:");
        System.out.println(binaryNumbers);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredWords = ListOperations.filterAndSortByLength(words, alphabet);
        System.out.println("\nФильтрация и сортировка слов по алфавиту и длине:");
        System.out.println(filteredWords);
    }
}
