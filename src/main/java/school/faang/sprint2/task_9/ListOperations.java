package school.faang.sprint2.task_9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListOperations {

    public static Set<List<Integer>> getUniquePairs(List<Integer> numbers, int target) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> numSet = new HashSet<>(numbers);

        numbers.forEach(num -> {
            int complement = target - num;
            if (numSet.contains(complement) && num != complement) {
                pairs.add(Arrays.asList(Math.min(num, complement), Math.max(num, complement)));
            }
        });

        return pairs;
    }

    public static List<String> sortCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(String::compareToIgnoreCase))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterFruits(List<String> fruits, String symbol) {
        return fruits.stream()
                .filter(fruit -> fruit.startsWith(symbol))
                .sorted(Comparator.comparingInt(String::length))
                .sorted(Comparator.comparing(String::toLowerCase))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortWords(List<String> wordsToSort, String alphabet) {
        return wordsToSort.stream()
                .filter((s) -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparing(String::toLowerCase))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
