package school.faang.sprint_1.task_streamapi2bjs2n47308;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Operations {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, Integer sum) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCapitalsOfCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStrings(List<String> strings, char startSymbol) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startSymbol)))
                .sorted()
                .toList();
    }

    public static List<String> toBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabet(List<String> strings, String alphabet) {
        String regExp = alphabetToRegularExpression(alphabet);
        return strings.stream()
                .filter(s -> s.matches(regExp))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static String alphabetToRegularExpression(String alphabet) {
        return "^[" + alphabet + "]+$";
    }
}
