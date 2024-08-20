package faang.school.godless.reverse;

import faang.school.godbless.reverse.Example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    @Test
    void testReverse() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] reversedArr = {5, 4, 3, 2, 1};

        Assertions.assertArrayEquals(reversedArr, Example.reverse(arr));
    }
}
