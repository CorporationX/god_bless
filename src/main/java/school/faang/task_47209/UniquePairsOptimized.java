package school.faang.task_47209;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniquePairsOptimized {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int target = 7;
        Set<List<Integer>> pairs = findPairs(numbers, target);
        pairs.forEach(System.out::println);
    }
}