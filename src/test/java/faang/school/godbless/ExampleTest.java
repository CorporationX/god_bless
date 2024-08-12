package faang.school.godbless;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.Example.reverse;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void reverseEmptyArray() {
        int[] a = {};
        reverse(a);
        assertArrayEquals(new int[0], a);
    }

    @Test
    void reverseArray() {
        int[] a = {1, 2, 3};
        reverse(a);
        assertArrayEquals(new int[]{3, 2, 1}, a);
    }

    @Test
    void reverseAnotherArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(a);
        assertArrayEquals(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, a);
    }
}
