package school.faang.bjs247183;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findPairs(List<Integer> nums, int sum) {
        validate(nums);
        Set<List<Integer>> pairs;
        Set<Integer> set = new HashSet<>(nums);
        pairs = nums.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public static Set<String> filterCountry(Map<String, String> countries) {
        validate(countries);
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public static List<String> filterAndSortWords(List<String> words, char symbol) {
        validate(words);
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> nums) {
        validate(nums);
        return nums.stream()
                .map(num -> Integer.toString(num, 2))
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> words, String alphabet) {
        validate(words);
        validate(alphabet);
        String regex = "[" + alphabet + "]+";
        return words.stream()
                .filter(word -> word.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static void validate(Object object) {
        if (object == null) {
            throw new NullPointerException("Argument must be not null");
        }
    }
}
