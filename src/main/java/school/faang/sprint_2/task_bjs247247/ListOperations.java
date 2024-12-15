package school.faang.sprint_2.task_bjs247247;

import lombok.experimental.UtilityClass;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class ListOperations {

    public List<Map.Entry<Integer, Integer>> findUniquePairs(List<Integer> numbers, int target) {
        return numbers.stream()
                .distinct()
                .flatMap(firstNumber -> numbers.stream()
                        .distinct()
                        .filter(secondNumber -> firstNumber < secondNumber && firstNumber + secondNumber == target)
                        .map(secondNumber ->
                                (Map.Entry<Integer, Integer>) new AbstractMap.SimpleEntry<>(firstNumber, secondNumber)))
                .toList();
    }

    public List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterAndSortByLength(List<String> strings, char stringStart) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(stringStart)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public List<String> toBinaryString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAlphabetSortByLength(List<String> strings, String alphabet) {
        Set<Character> alphabetChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(string -> string.chars()
                        .allMatch(letter -> alphabetChars.contains((char) letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
