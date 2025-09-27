package school.faang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOfOperations {

    public List<List<Integer>> findPairs(Set<Integer> numbers, int value) {
        return numbers.stream()
                .filter(number -> numbers.contains(value - number) && number != value - number)
                .map(number -> Arrays.asList(Math.min(number, value - number), Math.max(number, value - number)))
                .distinct()
                .toList();
    }

    public List<String> findCapital(Map<String, String> countryAndCapitals) {
        return countryAndCapitals.values().stream()
                .toList();
    }

    public List<String> startsWithChar(List<String> words, Character ch) {
        return words.stream()
                .filter(word -> word.charAt(0) == ch)
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
    }

    public List<String> toBinary(Set<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterThenSortByLength(List<String> words, String alphabet) {
        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        return words.stream()
                .filter(word -> word.chars().allMatch(ch -> alphabetSet.contains((char) ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
