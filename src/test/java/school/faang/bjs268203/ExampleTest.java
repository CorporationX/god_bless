package school.faang.bjs268203;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ExampleTest {
    @Test
    public void testReverseNormalArray() {
        Integer[] numbers = new Integer[]{3, 6, 5, 1, 4, 2};

        Example.reverse(numbers);

        assertArrayEquals(new Integer[]{2, 4, 1, 5, 6, 3}, numbers);
    }

    @Test
    public void testReverseIncreasingArray() {
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};

        Example.reverse(numbers);

        assertArrayEquals(new Integer[]{5, 4, 3, 2, 1}, numbers);
    }

    @Test
    public void testReverseDecreasingArray() {
        Integer[] numbers = new Integer[]{5, 4, 3, 2, 1};

        Example.reverse(numbers);

        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, numbers);
    }

    @Test
    public void testReverseEmptyArray() {
        Integer[] numbers = new Integer[]{};

        Example.reverse(numbers);

        assertArrayEquals(new Integer[]{}, numbers);
    }
}