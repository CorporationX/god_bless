package faang.school.godbless.BJS222421;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static List<List<Integer>> findPairsWithSum(List<Integer> numbers, int targetSum){
        Map<Boolean, List<Integer>> grouped = numbers
                .stream()
                .collect(Collectors.partitioningBy(num -> ));
    }
}
