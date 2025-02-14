package school.faang.secondstreamtraining;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        if (numbers == null) {
            return Collections.emptySet();
        }
        return numbers.stream()
                .filter(firstNumber -> numbers.contains(sum - firstNumber) && sum - firstNumber < firstNumber)
                .map(firstNumber -> List.of(firstNumber, sum - firstNumber))
                .collect(Collectors.toSet());
    }

    public List<String> sortCountriesAndPrintCapitals(Map<String, String> countriesCapitals) {
        if (countriesCapitals == null) {
            return Collections.emptyList();
        }
        return countriesCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public List<String> filterAndSortStrings(List<String> strings, char firstChar) {
        return filterNonNull(strings).stream().filter(word -> word.charAt(0) == firstChar)
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public List<String> transformDecimalToBinary(List<Integer> decimals) {
        return filterNonNull(decimals).stream().map(Integer::toBinaryString).toList();
    }

    public List<String> filterByAlphabetSortByLength(List<String> words, String alphabet) {
        if (alphabet == null) {
            return Collections.emptyList();
        }
        Set<Character> alphabetChars = alphabet.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        return filterNonNull(words).stream().filter(word -> word.chars().mapToObj(ch -> (char) ch)
                .allMatch(alphabetChars::contains)).sorted(Comparator.comparingInt(String::length)).toList();
    }

    private <T> List<T> filterNonNull(List<T> list) {
        return (list == null) ? Collections.emptyList() : list.stream().filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
