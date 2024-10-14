package school.faang.sprint_2.bjs2_35194;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StreamOperations {
    public Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs;
        Set<Integer> set = new HashSet<>(numbers);
        pairs = numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<String> filterAndSort(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> decimalToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterByAlphabetSortByLength(List<String> strings, String alphabet) {
        Set<String> alphabetSet = Set.of(alphabet.split(""));

        return strings.stream()
                .filter(s -> Arrays.stream(s.split(""))
                        .allMatch(alphabetSet::contains))
                .toList();
    }
}
