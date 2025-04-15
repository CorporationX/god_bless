package school.faang.second_stream;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class StreamUtil {

    public static Collection<List<Integer>> uniqueSumFinder(Set<Integer> numbers, Integer sum) {
        return numbers.stream()
                .map(number ->
                        List.of(Math.min(number, sum - number), Math.max(number, sum - number)))
                .filter(contender ->
                        contender.stream()
                                .distinct()
                                .count() > 1
                                && numbers.containsAll(contender))
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet()
                .stream()
                .sorted((Map.Entry.comparingByKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortWordsStartsWith(List<String> words, String startsWith) {
        return words.stream()
                .filter(word -> word.startsWith(startsWith))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> alphabetMatch(List<String> words, String alphabet) {
        return words.stream()
                .filter(word ->
                        word.chars()
                                .allMatch(chr -> alphabet.indexOf(chr) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
