package school.faang.streamapitwo;

import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TrainingStreamApi {

    public static Set<Pair<Integer, Integer>> findUniquePairs(Set<Integer> nums, int value) {
        if (nums == null) {
            throw new IllegalArgumentException("Set must not be null!");
        }
        Set<Pair<Integer, Integer>> result = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (int n : nums) {
            int complement = value - n;
            if (seen.contains(complement)) {
                result.add(new Pair<>(min(n, complement), max(n, complement)));
            }
            seen.add(n);
        }
        return result;
    }

    public static List<String> getSortedCapitals(Map<String, String> capitalsByCountries) {
        if (capitalsByCountries == null) {
            throw new IllegalArgumentException("Map must not be null!");
        }
        return capitalsByCountries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByFirstChar(List<String> strings, char firstChar) {
        if (strings == null) {
            throw new IllegalArgumentException("List must not be null!");
        }
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == firstChar)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> toBinaryList(List<Integer> nums) {
        if (nums == null) {
            throw new IllegalArgumentException("List must not be null!");
        }
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, String alphabet) {
        if (strings == null) {
            throw new IllegalArgumentException("List must not be null!");
        }
        BitSet allowed = new BitSet();
        for (char c : alphabet.toCharArray()) {
            allowed.set(c);
        }
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.chars().allMatch(allowed::get))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
