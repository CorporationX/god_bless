package school.faang.stream2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

public class StreamFunctions {

    public static List<Pair<Integer, Integer>> findPairs(Set<Integer> set, int pairSum) {
        return set.stream()
                .filter(num -> set.contains(pairSum - num) && num < pairSum - num)
                .map(num -> new Pair<>(num, pairSum - num))
                .toList();
    }

    public static List<String> sortedCapitals(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLength(List<String> list, char symbol) {
        return list.stream()
                .filter(s -> s.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> listNum) {
        return listNum.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSort(List<String> list, String alphabet) {
        String regex = "^[" + alphabet + "]+$";

        return list.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

}


