package school.faang.stream_optional.bjs2_87992;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {

    public Set<List<Integer>> getPairsThatSumEqualsArgument(int sum, Set<Integer> numbers) {
        return
                numbers.stream()
                        .filter(num -> numbers.contains(sum - num) && num != sum - num)
                        .map(num -> Arrays.asList(num, sum - num))
                        .peek(Collections::sort)
                        .collect(Collectors.toSet());
    }

    public List<String> getSortedMapValues(Map<String, String> valuesMap) {
        return valuesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterByChar(List<String> strings, char filterChar) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(filterChar)))
                .sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo))
                .toList();
    }

    public List<String> getBinaryFormat(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public List<String> filterByAllWordCharsContainsInString(List<String> words, String filterString) {
        return words.stream().filter(
                str -> {
                    boolean b = true;
                    for (char c : str.toCharArray()) {
                        if (!filterString.contains(String.valueOf(c))) {
                            b = false;
                            break;
                        }
                    }
                    return b;
                }
        ).sorted(Comparator.comparing(String::length)).toList();
    }
}