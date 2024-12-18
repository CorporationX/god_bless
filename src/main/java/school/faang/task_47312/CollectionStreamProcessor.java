package school.faang.task_47312;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionStreamProcessor {
    public Set<List<Integer>> getNumberPairs(List<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public List<String> getSortedCapitals(Map<String, String> capitalsAndCountries) {
        return capitalsAndCountries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> getSortedList(List<String> list, char symbol) {
        return list.stream()
                .filter(string -> string.indexOf(symbol) == 0)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> getFilteredStrings(List<String> strings) {
        String alf = "abcdefghijklmnopqrstuvwxyz";
        String regex = "[" + alf + "]+";

        return strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
