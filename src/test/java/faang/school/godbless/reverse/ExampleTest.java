package faang.school.godbless.reverse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    private int[] arrayOne;
    private int[] arrayTwo;

    @BeforeEach
    public void setUp() {
        arrayOne = new int[]{1, 2, 3, 4, 5, 6};
        arrayTwo = new int[]{6, 5, 4, 3, 2, 1};
    }

    @Test
    public void testReverseMethod() {
        Example.reverse(arrayOne);
        assertEquals(arrayOne[0], arrayTwo[0]);
        assertEquals(arrayOne[1], arrayTwo[1]);
        assertEquals(arrayOne[2], arrayTwo[2]);
        assertEquals(arrayOne[3], arrayTwo[3]);
        assertEquals(arrayOne[4], arrayTwo[4]);
    }
}
