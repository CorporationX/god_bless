package school.faang.task_47356;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> findUniquePairsWithCertainSum(List<Integer> source, int sum) {
        Set<Integer> set = new HashSet<>(source);

        return source.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> {
                    set.remove(num);
                    set.remove(sum - num);
                    return Arrays.asList(num, sum - num);
                })
                .collect(Collectors.toSet());
    }

    public static List<String> findSortedCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> findSortedCapitalsWithTreeMap(Map<String, String> countriesAndCapitals) {
        Map<String, String> treeMap = new TreeMap<>(countriesAndCapitals);
        return treeMap.values().stream()
                .toList();
    }

    public static List<String> findStartsWithAndSortedByLength(List<String> source, char symbol) {
        return source.stream()
                .filter(it -> it.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertDecimalsDigitsToBinary(List<Integer> source) {
        return source.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> findWordWithCertainLettersAndSortedByLength(List<String> source, String alphabet) {
        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return source.stream()
                .filter(it -> it.chars().allMatch(c -> alphabetSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
