package school.faang.streamtrain2;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class SecondStreamTesting {
    public static void main(String[] args) {

        Set<Integer> numbersSet = Set.of(1, 2, 3, 4, 5, 6, 7);
        log.info(String.valueOf(StreamMethod2.getPairsWithSum(numbersSet, 7)));

        Map<String, String> capitals =
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        log.info(String.valueOf(StreamMethod2.alphabetSortedCapitals(capitals)));

        List<String> fruits = List.of("apple", "banana", "cherry", "date", "fig", "grape", "avocado");
        log.info(String.valueOf(StreamMethod2.sortedLines(fruits, 'a')));

        List<Integer> numbers = List.of(1, 2, 3, 4);
        log.info(String.valueOf(StreamMethod2.toBinaryString(numbers)));

        log.info(String.valueOf(StreamMethod2.filterLines(fruits, "abcdefghijklmnop")));
    }
}
