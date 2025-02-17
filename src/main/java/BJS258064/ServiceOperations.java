package BJS258064;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceOperations {

    public Set<List<Integer>> getPairNumbers(Set<Integer> numbers, Integer number) {
        return numbers.stream().filter(numInSet ->
                        numInSet != number - numInSet && numbers.contains(number - numInSet))
                .map(numInSet -> Arrays.asList(numInSet, number - numInSet))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public List<String> getCapitalOfCountry(Map<String, String> countryAndCapital) {
        return countryAndCapital
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filteredAndSortedStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> fromIntToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterByAlphabetSortByLength(List<String> stringList, String symbols) {
        return stringList.stream()
                .filter(s -> s.matches(symbols))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
