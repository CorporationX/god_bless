package school.faang.sprint_1.task_streamapi2bjs2n47308;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Operations {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, Integer sum) {
        Set<Integer> set = new TreeSet<>(numbers);
        return set.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .map(pair -> {
                    Collections.sort(pair);
                    return List.of(pair.get(0), pair.get(1));
                })
                .sorted((o1, o2) -> o1.get(0).compareTo(o2.get(1)))
                .collect(Collectors.toCollection(LinkedHashSet::new));

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
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> toBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(stringMatchesAlphabet(alphabet))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static Predicate<String> stringMatchesAlphabet(String alphabet) {
        return s -> s.matches("^[" + alphabet + "]+$");
    }
}
