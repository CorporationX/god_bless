package school.faang.BJS2_35420;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Optinal {
    public static List<int[]> findPairsNumbers(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums)
            .filter(num -> set.add(k - num) && num < k - num)
            .mapToObj(num -> new int[] {num, k - num})
            .collect(Collectors.toList());
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> countries, String firstLetter) {
        return countries.stream()
            .filter(str -> str.startsWith(firstLetter))
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
    }

    public static List<String> transformationToBinary(List<Integer> numbers) {
        return numbers.stream()
            .map(Integer::toBinaryString)
            .collect(Collectors.toList());
    }

    public static List<String> sortStringsByAlphabet(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]";
        return strings.stream()
            .filter(str -> str.chars().anyMatch(ch -> regex.indexOf(ch) >= 0))
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
    }
}
