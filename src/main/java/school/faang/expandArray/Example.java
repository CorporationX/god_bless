package school.faang.expandArray;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Example {
    public static int[] reverse(int[] nums) {
        return IntStream.of(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}