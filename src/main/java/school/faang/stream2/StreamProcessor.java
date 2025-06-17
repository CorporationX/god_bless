package school.faang.stream2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProcessor {

    public static Set<Pair> findUniquePairWithSumIsNum(Set<Integer> set, int num) {
        return set.stream().flatMap(a -> {
            int b = num - a;
            return set.contains(b) && a < b ? Stream.of(new Pair(a, b)) : Stream.empty();
        }).collect(Collectors.toSet());
    }

    public static List<String> sortByCountryAndGetCapitals(Map<String, String> countriesAndCapitalsMap) {
        return countriesAndCapitalsMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> sortByFirstSymbol(List<String> list, char a) {
        return list.stream().filter(s -> s.startsWith(String.valueOf(a))).sorted(String::compareTo).toList();
    }

    public static List<Integer> numbersByBinary(List<Integer> list) {
        return list.stream().map(Integer::toBinaryString).map(Integer::valueOf).toList();
    }

    public static List<String> sortByAlphabetAndLength(List<String> stringList, String letters) {
        Set<Character> uniqueLetters = letters.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return stringList.stream()
                .filter(s -> s.chars().allMatch(c -> uniqueLetters.contains((char) c)))
                .sorted(Comparator.comparing(String::length)).toList();
    }

}
