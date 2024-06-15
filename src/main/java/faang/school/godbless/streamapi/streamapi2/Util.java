package faang.school.godbless.streamapi.streamapi2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {

    public static Set<IntPair> findUniqueIntPairs(List<Integer> integers, int targetSum) {
        return integers.stream()
                .flatMap(i -> integers.stream()
                        .filter(j -> !i.equals(j))
                        .filter(j -> i + j == targetSum)
                        .map(j -> {
                            if (i < j) {
                                return new IntPair(i, j);
                            } else {
                                return new IntPair(j, i);
                            }
                        }))
                .collect(Collectors.toSet());
    }

    public static List<String> sortByKeyAndGetValuesList(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterByStartCharAndSortByLength(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.charAt(0) == c)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
