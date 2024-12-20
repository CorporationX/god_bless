package school.faang.bjs2x47505;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperation {
    public static List<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortLength(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertorToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLength(List<String> stringList, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return stringList.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }
}
