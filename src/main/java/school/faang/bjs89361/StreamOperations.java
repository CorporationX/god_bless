package school.faang.bjs89361;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Slf4j
public class StreamOperations {

    public static Set<List<Integer>> findUniqPairsOfNumber(Set<Integer> numbers, int targetSum) {
        log.info("Found unique pairs of numbers that sum up to " + targetSum);
        return numbers.stream()
            .flatMap(num1 -> numbers.stream()
                .filter(num2 -> num1 < num2 && num1 + num2 == targetSum)
                .map(num2 -> List.of(num1, num2)))
            .collect(Collectors.toSet());

    }

    public static Set<String> sortCountryNamesWithCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
            .map(entry -> entry.getValue())
            .collect(Collectors.toCollection(TreeSet::new));
    }

    public static List<String> filterAndSortStringValues(List<String> listString, String simbol) {
        return listString.stream()
            .filter(l -> l.startsWith(simbol))
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
    }

    public static List<String> convertNumberToBinar(List<Integer> integers) {
        return integers.stream()
            .map(Integer::toBinaryString)
            .collect(Collectors.toList());
    }

    public static List<String> filterOnlyLettersAlphabetAndSortByLength(List<String> stringList, String alphabet) {
        return stringList.stream()
            .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) != -1))
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
    }
}
