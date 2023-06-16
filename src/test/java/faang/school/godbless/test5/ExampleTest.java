package faang.school.godbless.test5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void testEvenReverse() {
        int[] testArrEven = {0, 1, 2, 3, 4, 5};
        Example.reverse(testArrEven);
        assertArrayEquals(new int[] {5,4,3,2,1}, testArrEven);
    }

    @Test
    void testOddReverse() {
        int[] testArrEven = {0, 1, 2, 3, 4};
        Example.reverse(testArrEven);
        assertArrayEquals(new  int[] {4,3,2,1}, testArrEven);
    }
}