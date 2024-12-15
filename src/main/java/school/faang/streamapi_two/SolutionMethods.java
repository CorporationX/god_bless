package school.faang.streamapi_two;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionMethods {
    public Set<List<Integer>> findUniquePairs(List<Integer> list, int sumOfPair) {
        Set<List<Integer>> foundPairs = new HashSet<>();
        Set<Integer> inputList = new HashSet<>();

        inputList.addAll(list);
        foundPairs = inputList.stream()
                .filter(number -> inputList.contains(sumOfPair - number))
                .map(number -> Arrays.asList(number, sumOfPair - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return foundPairs;
    }

    public List<String> sortCapitalByAlphabet(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> findStringStartingWithCharAndSort(List<String> list, char startingChar) {
        List<String> result = list.stream()
                .filter(str -> str.charAt(0) == startingChar)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        if (result.isEmpty()) {
            throw new NoSuchElementException("No strings match condition");
        }
        return result;
    }

    public List<String> convertIntegerToBinaryString(List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Input list is empty");
        }
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterByAlphabetAndSort(List<String> list, String alphabet) {
        String regex = String.format("[%s]+", alphabet);
        List<String> result = list.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        if (result.isEmpty()) {
            throw new NoSuchElementException("No strings include chars from alphabet");
        }
        return result;
    }
}
