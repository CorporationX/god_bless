package school.faang.task57988;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {


    public static Set<List<Integer>> uniqueNums(int target, Set<Integer> nums) {
        return nums.stream()
                .filter(n -> nums.contains(target - n) && n < target / 2)
                .map(n -> List.of(n, target - n))
                .collect(Collectors.toSet());
    }

    public static List<String> findSortedCapitals(Map<String, String> countries) {
        return countries.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> findSortedWords(char character, List<String> words) {
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(character)))
                .sorted()
                .toList();
    }

    public static List<String> findBinaryCodes(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterWordsAndSort(List<String> words, String alphabet) {
        return words.stream()
                .filter(word -> word.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
