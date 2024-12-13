package school.faang.task_47173;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);

        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, char symbol) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
