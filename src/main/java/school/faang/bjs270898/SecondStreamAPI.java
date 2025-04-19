package school.faang.bjs270898;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecondStreamAPI {
    public static List<List<Integer>> findPairs(Set<Integer> setNumbers, int targetNumber) {
        return setNumbers.stream()
                .filter(num ->
                        setNumbers.contains(targetNumber - num))
                .map(num -> List.of(num, targetNumber - num))
                .toList();
    }

    public static List<String> capitalsSorted(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByFirstLetter(List<String> list, char firstLetter) {
        return list.stream()
                .filter(string -> !string.isEmpty() && string.startsWith(String.valueOf(firstLetter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> toBinaryString(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSort (List<String> list, String alphabet) {
        return list.stream()
                .filter(string -> string.chars().allMatch(ch -> alphabet.indexOf(ch)>=0))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
