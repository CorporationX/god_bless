package practiceStreamAPI_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String... args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(findUniqPairs(numbers, 7));

        Map<String, String> capitals = Map.of(
            "Russia", "Moscow",
            "USA", "Washington",
            "Germany", "Berlin"
        );
        System.out.println(sortByKeyAndGetValue(capitals));

    }

    public static Set<List<Integer>> findUniqPairs(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortByKeyAndGetValue(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }


}
