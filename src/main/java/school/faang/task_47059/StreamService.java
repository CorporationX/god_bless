package school.faang.task_47059;

import school.faang.exception.CheckException;

import java.util.*;
import java.util.stream.Collectors;

public class StreamService {
    public Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        if (numbers == null) {
            throw new CheckException("numbers");
        }
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public List<String> getSortedCapitals(Map<String, String> countries) {
        if (countries == null) {
            throw new CheckException("countries");
        }
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> filterAndSort(List<String> strings, char letter) {
        if (strings == null) {
            throw new CheckException("strings");
        }
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> convertToBinary(List<Integer> nums) {
        if (nums == null) {
            throw new CheckException("nums");
        }
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        if (strings == null) {
            throw new CheckException("strings");
        }
        if (alphabet == null || alphabet.isEmpty()) {
            throw new CheckException("alphabet");
        }

        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
