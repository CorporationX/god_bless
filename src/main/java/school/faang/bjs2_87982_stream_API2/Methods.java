package school.faang.bjs2_87982_stream_API2;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Methods {
    public static List<List<Integer>> findUniqueNumbersPairWithSum(Set<Integer> numbers, int targetSum) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .flatMap(n1 -> numbers.stream()
                        .filter(n2 -> n1 < n2)
                        .filter(n2 -> n1 + n2 == targetSum)
                        .map(n2 -> List.of(n1, n2)))
                .toList();
    }
}