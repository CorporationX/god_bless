package school.faang;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> {
                    List<Integer> pair = Arrays.asList(num, sum - num);
                    Collections.sort(pair);
                    return pair;
                })
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterString(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startChar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> binaryForm(List<Integer> number) {
        return number.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortedAndChar(List<String> strings, String alph) {
        String regex = "[" + alph + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }
}

