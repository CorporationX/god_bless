package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;

public class UniquePairOfNumbers {
    public static List<List<Integer>> findUniquePairs(List<Integer> num, int targetNumber) {
        Set<Integer> listNum = new HashSet<>(num);
        return num.stream()
                .map(number -> List.of(number, targetNumber - number))
                .filter(n -> listNum.contains(n.get(1)))
                .filter(n -> n.get(0) < n.get(1) || (listNum.contains(n.get(0)) && n.get(1) * 2 == targetNumber))
                .distinct()
                .collect(Collectors.toList());
    }
}