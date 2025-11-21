package school.faang.bjs2_87918;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Pairs: " + ListOperations.findPairs(nums, 6));

        Map<String, String> capitals = new HashMap<>();
        capitals.put("Russia", "Moscow");
        capitals.put("France", "Paris");
        capitals.put("Germany", "Berlin");
        System.out.println("Capitals in order: " + ListOperations.getCapitalsInOrder(capitals));

        List<String> fruits = List.of("apple", "apricot", "banana", "avocado", "pear");
        System.out.println("Filter and sort by 'a': " + ListOperations.filterAndSortStrings(fruits, 'a'));

        System.out.println("Binary format: " + ListOperations.convertToBinaryFormat(List.of(1, 2, 3, 4, 5)));

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Filtered and sorted words: " +
                ListOperations.filterAndSortWords(words, alphabet));
    }
}
