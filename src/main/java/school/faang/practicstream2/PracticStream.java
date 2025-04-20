package school.faang.practicstream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PracticStream {

    public Set<List<Integer>> sortNumbersByPairs(Set<Integer> numbers, Integer sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public List<String> sortCountriesAndOutputCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterAndSortedString(List<String> strings, char ch) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> tarnsformationNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> Integer.toString(num, 2))
                .toList();
    }

    public List<String> sortAlphabetically(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}