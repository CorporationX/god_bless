package school.faang.task_57825;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> mapStr) {
        return mapStr.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSort(List<String> list, char simbol) {
        return list.stream()
                .filter(str -> str.charAt(0) == simbol)
                .sorted((str1, str2) -> str1.length() - str2.length())
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());

    }

    public static List<String> filterAndSortByLength(List<String> list, String alphabet) {
        return list.stream()
                .filter(str -> str.contains(alphabet))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

}
