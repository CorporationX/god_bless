package school.faang.bjs247079;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

    }

    public static Set<List<Integer>> findPairs(List<Integer> list, int sum) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (Integer n : list) {
            if (set.contains(sum - n)) {
                result.add(List.of(n, sum - n));
            } else {
                set.add(n);
            }
        }
        return result;
    }

    public static List<String> findAndSortCapitals(Map<String, String> map) {
        return map.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> filterAccordingOneCharacterAndSort(List<String> list, char c) {
        return list.stream()
                .filter(el -> el.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .sorted()
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAccordingManyCharactersAndSort(List<String> list, String alphabet) {
        return list.stream()
                .filter(el -> el.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

}
