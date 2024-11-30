import faang.school.godbless.turn_around.Example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class reversTest {

    @Test
    void reversTest() {
        Example example = new Example();
        int[] expected = new int[]{3, 2, 1};
        int[] result = example.reverse(new int[]{1, 2, 3});

        assertArrayEquals(expected, result);
    }
}
