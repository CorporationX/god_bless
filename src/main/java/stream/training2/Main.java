package stream.training2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> getPairs(List<Integer> nums, int sum) {
        return null;

    }

    public static List<List<Integer>> getNumberPairs(int[] numbers) {
        return IntStream.range(0, numbers.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.length)
                        .mapToObj(j -> Arrays.asList(numbers[i], numbers[j])))
                .collect(Collectors.toList());
    }
}
