package StreamAPI2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class StreamManager {
    public Set<List<Integer>> findUniquePairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        pairs = numbers.stream()
                .filter(n -> set.contains(sum - n))
                .map(n -> Arrays.asList(n, sum - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public List<String> countrySort(Map<String, String> countries) {
        return countries.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted()
                .toList();
    }

    public List<String> sortStringForLenth(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public List<String> makesBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterByLetterContend(List<String> stringList, String alphabet) {
        return stringList.stream()
                .filter(s -> s.chars().allMatch(ch -> alphabet.indexOf(ch) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

    }

}
