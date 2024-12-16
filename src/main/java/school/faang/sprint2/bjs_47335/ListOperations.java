package school.faang.sprint2.bjs_47335;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> sumDistinctPairs(List<Integer> digits, int sum) {
        return digits.stream()
                .filter(x -> digits.contains(sum - x))
                .map((a) -> Arrays.asList(a, sum - a))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filteredBySymbol(List<String> words, char symbol) {
        return words.stream()
                .filter(x -> x.startsWith(String.valueOf(symbol)))
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> digits) {
        return digits.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filteredByString(List<String> words, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return words.stream()
                .filter(x -> x.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
