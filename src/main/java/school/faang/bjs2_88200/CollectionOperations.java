package school.faang.bjs2_88200;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionOperations {

    public static Set<Map.Entry<Integer, Integer>> findPairsWithSum(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(n -> numbers.contains(target - n))
                .filter(n -> n < target - n)
                .map(n -> Map.entry(n, target - n))
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> country) {
        return country.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> list, char symbol) {
        return list.stream()
                .filter(s -> s.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinaryStrings(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByAlphabet(List<String> list, String alphabet) {
        String regex = "[" + alphabet + "]*";
        return list.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
