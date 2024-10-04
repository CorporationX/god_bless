package school.faang.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoPointerTest {

    @Test
    void reverseArrayTest() {
        assertArrayEquals(new int[]{5,4,3,2,1}, TwoPointer.reverse(new int[]{1,2,3,4,5}));
    }
}