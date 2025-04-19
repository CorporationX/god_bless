package school.faang.bjs270898;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.bjs270898.SecondStreamApi.*;

public class Main {
    public static void main(String[] args) {

        Set<Integer> nums = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(findPairs(nums, 6));

        Map<String, String> map = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");

        System.out.println(capitalsSorted(map));

        List<String> words = List.of("apple", "banana", "avocado", "apricot");
        System.out.println(filterAndSortByFirstLetter(words, 'a'));

        List<Integer> num = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println(toBinaryString(num));

        List<String> words2 = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(filterByAlphabetAndSort(words2, alphabet));
    }
}
