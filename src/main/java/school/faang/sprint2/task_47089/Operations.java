package school.faang.sprint2.task_47089;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {

    public Set<List<Integer>> findPairs(@NonNull List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        pairs = numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public List<String> sortCapitalsOfCountries(@NonNull Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map((o) -> o.getValue()).toList();
    }

    public List<String> sortByLengthStartingWith(@NonNull List<String> strings, char firstLetter) {
        return strings.stream()
                .filter((s) -> s.startsWith(String.valueOf(firstLetter)))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public List<String> convertToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterStringsFromAlphabetSortByLength(@NonNull List<String> list, String alphabet) {
        return list.stream()
                .filter((c) -> {
                    for (char character : c.toCharArray()) {
                        if (!alphabet.contains(String.valueOf(character))) {
                            return false;
                        }
                    }
                    return true;
                }).sorted(((o1, o2) -> o1.length() - o2.length())).toList();
    }
}
