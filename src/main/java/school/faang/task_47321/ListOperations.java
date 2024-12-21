package school.faang.task_47321;


import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class ListOperations {
    private final List<Integer> integerList;

    public ListOperations(List<Integer> integerList) {
        this.integerList = integerList;
    }


    public List<Pair<Integer, Integer>> findUniquePairs(int targetNumber) {
        Set<Integer> integerSet = new HashSet<>();
        return integerList.stream()
                .filter(num -> {
                    int complement = targetNumber - num;
                    if (integerSet.contains(complement)) {
                        return true;
                    }
                    integerSet.add(num);
                    return false;
                })
                .map(num -> Pair.of(targetNumber - num, num))
                .sorted()
                .toList();
    }

    public List<String> findSortedCapitals(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> findSortedStringsStartsWith(List<String> givenStrings, String startString) {
        return givenStrings.stream()
                .filter(strings -> strings.startsWith(startString))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public List<String> findBinaryListFromIntegers(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAllMatchingAsc(List<String> givenStrings, String alphabet) {
        return givenStrings.stream()
                .filter(string -> string.chars()
                        .allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
