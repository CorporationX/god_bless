package ru.maks1979.task_47268;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamApi {

    public Map<Integer, Integer> filterUniquePairs(List<Integer> listOfNums, Integer someInt) {
        Map<Integer, Integer> mapOfUnicPairs = new HashMap<>();
        listOfNums.stream().forEach(num -> {
            Integer complement = someInt - num;
            if (listOfNums.contains(complement) && !mapOfUnicPairs.containsKey(complement)
                    && !mapOfUnicPairs.containsValue(complement)) {
                mapOfUnicPairs.put(num, complement);
            }
        });
        return mapOfUnicPairs;
    }

    public List<String> capitalSorting(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.keySet()
                .stream()
                .sorted()
                .map(countriesAndCapitals::get)
                .collect(Collectors.toList());
    }

    public List<String> filterAndSort(List<String> listOfWords, String symbolForChoise) {
        return listOfWords.stream()
                .filter(word -> word.contains(symbolForChoise))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public List<String> intToString(List<Integer> listOfNums) {
        return listOfNums.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, Set<Character> alphabet) {
        return strings.stream()
                .filter(s -> {
                    for (char c : s.toCharArray()) {
                        if (!alphabet.contains(c)) {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}


