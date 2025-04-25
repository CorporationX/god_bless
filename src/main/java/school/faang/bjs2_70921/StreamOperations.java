package school.faang.bjs2_70921;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    private StreamOperations() {
    }

    public static Set<Set<Integer>> getPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num < sum - num && numbers.contains(sum - num))
                .map(num -> Set.of(num, sum - num))
                .collect(Collectors.toSet());
    }

    public static List<String> sortStringMap(Map<String, String> map) {
        return map.keySet().stream()
                .sorted()
                .map(map::get)
                .toList();
    }

    public static List<String> getStartWithPrefixAndSortedByLength(List<String> strings, String prefix) {
        return strings.stream()
                .filter(x -> x.startsWith(prefix))
                .sorted() //сортировка по алфавиту, на случай если несколько элементов будут одной длины
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertIntToBinString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        Set<String> alphabetSymbols = new HashSet<>(List.of(alphabet.split("")));
        return strings.stream()
                .filter(x -> alphabetSymbols.containsAll(List.of(x.split(""))))
                .sorted() //сортировка по алфавиту, на случай если несколько элементов будут одной длины
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
