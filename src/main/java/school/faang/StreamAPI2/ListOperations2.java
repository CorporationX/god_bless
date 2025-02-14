package school.faang.StreamAPI2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations2 {
    // Вход: [1, 2, 3, 4, 5, 6], целевое число: 6
    // Выход: [(1, 5), (2, 4)]
    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> {
                    List<Integer> pair = Arrays.asList(num, sum - num);
                    Collections.sort(pair);
                    return pair;
                })
                .collect(Collectors.toSet());
    }
}


