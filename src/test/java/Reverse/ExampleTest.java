package Reverse;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.Reverse.Example.reverse;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {


    @Test
    void reverseTest() {
        int[] odd = {1, 2, 3, 4, 5};
        int[] even = {1, 2, 3, 4, 5, 6};

        int[] reversedOdd = reverse(odd);
        int[] reversedEven = reverse(even);

        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, reversedOdd);
        assertArrayEquals(new int[]{6, 5, 4, 3, 2, 1}, reversedEven);
    }
}