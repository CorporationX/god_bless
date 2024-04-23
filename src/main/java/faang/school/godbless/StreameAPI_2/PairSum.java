package faang.school.godbless.StreameAPI_2;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PairSum {
    public static List<List<Integer>> findingPairsOfNumbers (List<Integer> numbers, int targetSum) {
        HashSet<Integer> xList = new HashSet<>();
        return numbers.stream()
                .flatMap(i -> numbers.stream().skip(numbers.indexOf(i) + 1)
                        .filter(j -> !xList.contains(j) && i + j == targetSum)
                        .peek(j -> xList.add(j))
                        .map(j -> List.of(i, j)))
                .collect(Collectors.toList());
    }
}