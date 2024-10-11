package school.faang.stream_api_2_BJS2_35140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operator {

    public static Set<List<Integer>> findPairsNumbers(List<Integer> numbers, int numForCompare) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.stream()
                .filter((num) -> numbersSet.contains(numForCompare - num))
                .map((num) -> new ArrayList<>(Arrays.asList(num, numForCompare - num)))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> countries, String firstLetter) {
        return countries.stream()
                .filter((str) -> str.startsWith(firstLetter))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> transformationToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortStringsByAlphabet(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
