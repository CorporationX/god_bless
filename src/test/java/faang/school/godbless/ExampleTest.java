package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ExampleTest {
    private Example example;

    @BeforeEach
    public void setUp() {
        example = new Example();
    }

    @Test
    public void reverseNotEmptyArray() {
        int[] arr = new int[] {1, 2, 3, 4, 5};

        int[] result = example.reverse(arr);

        Assertions.assertEquals(Arrays.toString(new int[] {5, 4, 3, 2, 1}), Arrays.toString(result));
    }

    @Test
    public void reverseEmptyArray() {
        int[] arr = new int[] {};

        int[] result = example.reverse(arr);

        Assertions.assertEquals(Arrays.toString(new int[] {}), Arrays.toString(result));
    }
}