package school.faang.stream2.streamapi2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMethods {
    public static List<Set<Integer>> findCouples(Set<Integer> originalSet, Integer target) {
        return originalSet.stream()
                .filter(number -> target - number != number)
                .map(num -> Set.of(num, target - num))
                .distinct()
                .filter(originalSet::containsAll)
                .toList();
    }

    public static List<String> sortCountriesCapitals(Map<String, String> countryCapitals) {
        return countryCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, Character character) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByDictionary(List<String> words, String dictionary) {
        Set<Character> dictionarySet = dictionary.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        return words.stream()
                .filter(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .allMatch(dictionarySet::contains)
                )
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(findCouples(new HashSet<>(Set.of(1, 2, 3, 4, 5, 6)), 6));

        Map<String, String> countryCapitals = Map.of(
                "Netherlands", "Amsterdam",
                "Serbia", "Belgrade",
                "Spain", "Madrid",
                "Poland", "Warsaw"
        );
        System.out.println(sortCountriesCapitals(countryCapitals));

        System.out.println(filterAndSort(List.of("apple", "banana", "avocado", "apricot"), 'a'));

        System.out.println(convertToBinary(List.of(1, 2, 3, 4, 10)));

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println(filterByDictionary(words, "abcdefghijklmnopqstuvwxyz"));
    }
}
