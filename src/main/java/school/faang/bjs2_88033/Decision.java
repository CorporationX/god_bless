package school.faang.bjs2_88033;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Decision {
    public static List<List<Integer>> findCouplesBySum(Set<Integer> numbers, int requiredSum) {


        IntStream intStream = Arrays.stream(numbers);

        numbers.stream().range(0,  numbers.length)
                .forEach(i -> IntStream.range(0,  input.length)
                        .filter(j -> i != j && input[i] + input[j] == sum)
                        .forEach(j -> addPairs(input[i], input[j]))
                );
        return numbers.stream().reduce((a, b) -> requiredSum);
    }
}
