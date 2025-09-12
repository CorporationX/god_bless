package school.faang.stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Comparator;

public class StreamFunctions {

    public static List<Pair<Integer, Integer>> findPairs(Set<Integer> set, int pairSum) {

        List<Integer> list = new ArrayList<>(set);
        return IntStream.range(0, list.size())
                .boxed()
                .flatMap(i ->
                        IntStream.range(i + 1, list.size())
                                .filter(j -> list.get(i) + list.get(j) == pairSum)
                                .mapToObj(j -> new Pair<>(list.get(i), list.get(j)))
                )
                .collect(Collectors.toList());
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
                .sorted()
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> listNum) {
        return listNum.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSort(List<String> list, String alphabet) {
        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return list.stream()
                .filter(s -> s.chars()
                        .allMatch(c -> alphabetSet.contains((char) c))
                ).sorted(Comparator.comparingInt(String::length))
                .toList();
    }

}


