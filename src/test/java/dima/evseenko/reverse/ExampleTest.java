package dima.evseenko.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExampleTest {

    @Test
    void reverseValidHonestArray(){
        assertArrayEquals(new int[]{8,7,6,5,4,3,2,1}, Example.reverse(new int[]{1,2,3,4,5,6,7,8}));
    }

    @Test
    void reverseValidUnevenArray(){
        assertArrayEquals(new int[]{9,8,7,6,5,4,3,2,1}, Example.reverse(new int[]{1,2,3,4,5,6,7,8,9}));
    }

    @Test
    void reverseEmptyArray(){
        assertArrayEquals(new int[]{}, Example.reverse(new int[]{}));
    }

    @Test
    void reverseNull() {
        assertThrows(IllegalArgumentException.class, () -> Example.reverse(null));
    }
}