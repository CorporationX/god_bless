package school.faang.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApi2 {

    public record Pair<T>(T first, T second) {
    }

    public static List<Pair<Integer>> findPairsBySum(Set<Integer> elems, Integer sum) {
        return elems.stream()
                .filter(elem -> elem != sum - elem && elems.contains(sum - elem))
                .map(elem ->
                        elem < sum - elem ? new Pair<>(elem, sum - elem):new Pair<>(sum - elem, elem))
                .distinct()
                .toList();
    }

    public static Set<String> sortCapitals(Map<String, String> countryWithCapitals) {
        return countryWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public static List<String> findLinesStartingWith(List<String> lines, String startingWith) {
        return lines.stream()
                .filter(line -> line.startsWith(startingWith))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> converter(List<Integer> numbers, Integer base) {
        return numbers.stream()
                .filter(number -> number >= 0)
                .map(number -> Integer.toString(number, base))
                .toList();
    }

    public static List<String> filterByInputAlphabetAndSortLines(List<String> lines, String alphabet) {
        return lines.stream()
                .filter(line -> ! line.replaceAll(alphabet, "").isEmpty())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(findPairsBySum(Set.of(1, 2, 4, 3, 5, 6), 6));
        System.out.println(sortCapitals(Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        )));
        System.out.println(findLinesStartingWith(List.of("apple", "banana", "avocado", "apricot"), "a"));
        System.out.println(converter(List.of(1, 2, 3, 4), 2));
        System.out.println(filterByInputAlphabetAndSortLines(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"));

    }
}
