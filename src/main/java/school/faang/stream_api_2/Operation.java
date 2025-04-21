package school.faang.stream_api_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operation {
    public static Set<List<Integer>> findUniquePairs(List<Integer> nums, int sum) {
        return nums.stream()
                .filter(num -> num != sum - num && nums
                .contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort).collect(Collectors.toSet());
    }

    public static List<String> getCapitalsFromCountries(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStringsByChar(List<String> strings, char symbol) {
        return strings.stream()
                .filter(c -> c.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> integerListToBinaryFormat(List<Integer> nums) {
        return nums.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAndSort(List<String> strings, String alphabet) {
        return strings
                .stream()
                .filter(s -> s.matches(alphabet))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
