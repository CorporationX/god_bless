package school.faang.streamapi_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Проект: god_bless
 * Класс UniquePairs
 * Автор: Vital
 * Дата: 23.09.2025
 */

public class UniquePairs {
    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }
}