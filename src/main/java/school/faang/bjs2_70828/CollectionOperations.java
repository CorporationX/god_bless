package school.faang.bjs2_70828;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionOperations {
    public static List<Pair<Integer>> findUniquePairs(Set<Integer> integers, int number) {
        return integers.stream()
                .filter(num -> num != number - num && integers.contains(number - num))
                .map(num -> new Pair<>(num, number - num))
                .distinct()
                .toList();
    }

    public static List<String> mapToSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .map(entry -> entry.getValue())
                .sorted()
                .toList();
    }

    public static List<String> sortStringsStartsWithCharacter(List<String> strings, char character) {
        return strings.stream()
                .filter(string -> string.charAt(0) == character)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> mapNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars()
                        .mapToObj(c -> (char) c)
                        .allMatch(alphabetSet::contains)) // оставить только те строки, где все буквы входят в alphabet
                .sorted(Comparator.comparingInt(String::length)) // сортировка по длине
                .collect(Collectors.toList());
    }
}