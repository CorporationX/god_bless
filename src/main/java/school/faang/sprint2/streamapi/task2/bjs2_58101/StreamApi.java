package school.faang.sprint2.streamapi.task2.bjs2_58101;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi {
    Set<Integer> integerSet = Set.of(2, 6, 7, 5, -4, 0, 10, 3, 1, 13, 12);

    public static Set<List<Integer>> findNumberPairs(Set<Integer> set, int sum) {
        return set.stream().filter(num -> num < (sum - num) && set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num)).collect(Collectors.toSet());
    }

    public static List<String> sortCountryCapitalsList(Map<String, String> countryMap) {
        return countryMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public static List<String> sortStringListByLengthStartsWithSymbol(List<String> strings, char symbol) {
        return strings.stream().filter(str -> str.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static List<String> convertIntegerToBinaryNumberList(List<Integer> integers) {
        return integers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterWordsConsistOfAlphabetLettersAndSortByLength(List<String> strings,
                                                                                  String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream().filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }
}
