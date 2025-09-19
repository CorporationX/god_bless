package school.faang.bjs2_88070;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;

public class ListOperations {
    public static Set<List<Integer>> findUniqueNumberPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> (sum - num) != num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> filterByPrefixCharAndSortByLength(List<String> strings, char startSymbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(startSymbol)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> toBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
