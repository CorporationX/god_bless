package school.faang.bjs247288;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> uniquePairsOfNumbers(@NonNull List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);

        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

    }

    public static List<String> filterAndSort(@NonNull List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(@NonNull List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLength(@NonNull List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
