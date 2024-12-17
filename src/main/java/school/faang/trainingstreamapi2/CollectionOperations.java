package school.faang.trainingstreamapi2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionOperations {

    public static Set<List<Integer>> findUniqueNumberPairs(List<Integer> numbers, int targetNumber) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.stream()
                .filter(number -> set.contains(targetNumber - number))
                .map(number -> Arrays.asList(number, targetNumber - number))
                .map(pair -> pair.stream().sorted().toList())
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStringsStartingWith(List<String> list, char symbol) {
        return list.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> list, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return list.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
