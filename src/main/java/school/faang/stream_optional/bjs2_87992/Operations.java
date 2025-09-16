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
                        .filter(num -> numbers.contains(sum - num) && num != 6 - num)
                        .map(num -> Arrays.asList(num, sum - num))
                        .peek(Collections::sort)
                        .collect(Collectors.toSet());
    }

    public List<String> getSortedMapValues(Map<String, String> valuesMap) {
        return valuesMap.entrySet().stream()
                .map(entry -> entry.getKey())
                .sorted()
                .map(key -> valuesMap.get(key))
                .toList();
    }

    public List<String> filterByChar(List<String> strings, char filterChar) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(filterChar)))
                .sorted((s1, s2) -> {
                    int result = s1.length() - s2.length();
                    return result == 0 ? s1.compareTo(s2) : result;
                }).toList();
    }

    public List<String> getBinaryFormat(List<Integer> numbers) {
        return numbers.stream().map(num -> Integer.toBinaryString(num)).toList();
    }

    public List<String> filterByAllWordCharsContainsInString(List<String> words, String filterString) {
        return words.stream().filter(
                str -> {
                    boolean b = true;
                    for (char c : str.toCharArray()) {
                        if (!"abcdefghijklmnopqrstuvwxyz".contains(String.valueOf(c))) {
                            b = false;
                        }
                    }
                    return b;
                }
        ).sorted(Comparator.comparing(String::length)).toList();
    }
}