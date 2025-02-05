package school.faang.sprint.first.reverse;

import java.util.stream.IntStream;

public class Example {
    public static int[] reverse(int[] array) {
        return IntStream.rangeClosed(1, array.length)
                .map(i -> array[array.length - i])
                .toArray();
    }
}
