package school.faang.sprint_2.task_bjs247247;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class ListOperations {

    public Set<List<Integer>> findUniquePairs(List<Integer> numbers, int target) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.stream()
                .filter(number -> uniqueNumbers.contains(target - number))
                .map(number -> number < (target - number)
                        ? Arrays.asList(number, target - number)
                        : Arrays.asList(target - number, number))
                .collect(Collectors.toSet());
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
