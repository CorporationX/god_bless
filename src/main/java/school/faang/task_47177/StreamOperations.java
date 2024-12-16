package school.faang.task_47177;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOperations {

    public static List<Pair<Integer, Integer>> collectPair(List<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num ->numbers.contains(sum - num))
                .map(num -> {
                    Pair<Integer, Integer> pair = Pair.of(num, sum - num);
                    Collections.reverse(numbers);
                    return pair;
                })
                .distinct()
                .toList();
    }

    public static List<String> getSortedCapitals(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSort(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        Pattern pattern = Pattern.compile("[" + Pattern.quote(alphabet) + "]+");
        return strings.stream()
                .filter(str -> pattern.matcher(str).matches())
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
