package school.faang.expandArray;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.stream.IntStream;

@Slf4j
public class Example {
    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1, 0};
        log.info("Original array - [{}]", array);
        log.info("Reversed array - [{}]", reverse(array));
    }

    private static int[] reverse(int[] nums) {
        return IntStream.of(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}