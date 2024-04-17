package faang.school.godbless.Task_17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(uniquePairs(10, Arrays.asList(1, 9, 3, 6, 4, 5)));

    }

    static Map<Integer, Integer> uniquePairs(int sum, List<Integer> numbers) {
        Map<Integer, Integer> pairs = new HashMap<>();
        IntStream.range(0, numbers.size()).
                forEach(i -> IntStream.range(0, numbers.size()).
                        filter(j -> i != j && numbers.get(i) + numbers.get(j) == sum).
                        forEach(j -> {
                            if (!pairs.containsValue(numbers.get(i))) {
                                pairs.put(numbers.get(i), numbers.get(j));
                            }
                        }));
        return pairs;
    }
}
