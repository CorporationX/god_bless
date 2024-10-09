package school.faang.streamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public Set<List<Integer>> getPairsOfNumbers(List<Integer> numbers, int number) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream()
                .filter(num -> set.contains(number - num))
                .map(num -> {
                    List<Integer> pair = Arrays.asList(num, number - num);
                    Collections.sort(pair);
                    return pair;
                })
                .collect(Collectors.toSet());
    }


    public List<String> sortedCountryByLiteral(Map<String, String> coutryMap) {
        return coutryMap.values().stream().sorted().toList();
    }

    public List<String> sortedListByLiteral(List<String> stringList, char ch) {
        return stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparing(String::length))
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public List<String> convertToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filteringByAlphabet(List<String> stringList, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return stringList.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
    }
}
