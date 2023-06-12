package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static faang.school.godbless.Example.reverse;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {


    @Test
    void reverseTest() {
        int[] array = {1, 2, 3, 4, 5};

        int[] reversed = reverse(array);

        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, reversed);
    }
}