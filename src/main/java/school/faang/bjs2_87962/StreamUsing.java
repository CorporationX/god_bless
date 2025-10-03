package school.faang.bjs2_87962;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamUsing {

    public static Set<List<Integer>> findUniqueNumbers(Set<Integer> numbers, int numb) {
        return numbers.stream()
                .filter(num -> num != numb - num && numbers.contains(numb - num))
                .map(num -> Arrays.asList(num, numb - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> capitals) {
        return capitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> filterStrings(List<String> stringList, char symbol) {
        return stringList.stream()
                .filter(s -> s.charAt(0) == symbol)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortStringsByLength(List<String> stringList, String alphabet) {
        return stringList.stream()
                .filter(s -> s.matches("\\b\\w*[" + alphabet + "]\\w*\\b"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
