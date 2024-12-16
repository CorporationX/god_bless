package school.faang.bjs247183;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findPairs(List<Integer> nums, int sum) {
        if (nums == null) {
            throw new NullPointerException("Args must be not null");
        }
        Set<Integer> set = new HashSet<>(nums);
        return nums.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort).collect(Collectors.toSet());
    }

    public static Set<String> filterCountry(Map<String, String> countries) {
        if (countries == null) {
            throw new NullPointerException("Args must be not null");
        }
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public static List<String> filterAndSortWords(List<String> words, char symbol) {
        if (words == null) {
            throw new NullPointerException("Args must be not null");
        }
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> nums) {
        if (nums == null) {
            throw new NullPointerException("Args must be not null");
        }
        return nums.stream()
                .map(num -> Integer.toString(num, 2))
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> words, String alphabet) {
        if (words == null || alphabet == null) {
            throw new NullPointerException("Args must be not null");
        }
        String regex = "[" + alphabet + "]+";
        return words.stream()
                .filter(word -> word.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
