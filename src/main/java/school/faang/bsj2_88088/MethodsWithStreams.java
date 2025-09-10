package school.faang.bsj2_88088;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MethodsWithStreams {
    public Set<List<Integer>> getCoupleOfInteger(Set<Integer> integers, int sumForCheck) {
        return integers.stream()
                .filter(integer -> integer != sumForCheck - integer && integers.contains(sumForCheck - integer))
                .map(integer -> Arrays.asList(integer, sumForCheck - integer))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public Set<String> getOrderedCapitals(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public List<String> getOrderedStringsWithSymbol(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> getBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> getOrderedString(List<String> strings, String letters) {
        String regex = "[" + letters + "]+";
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

}
