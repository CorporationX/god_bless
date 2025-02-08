package school.faang.sprint1.task_BJS2_56355;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест класса Example")
class ExampleTest {
    private Example example;

    @BeforeEach
    public void setUp() {
        example = new Example();
    }

    @Test
    public void reverse_oddNumberOfElements() {
        int[] array = {Integer.MIN_VALUE, 0, 2, 42, 23462, -75, Integer.MAX_VALUE};
        int[] expected = {Integer.MAX_VALUE, -75, 23462, 42, 2, 0, Integer.MIN_VALUE};

        example.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void reverse_evenNumberOfElements() {
        int[] array = {Integer.MIN_VALUE, 2, 42, 23462, -75, Integer.MAX_VALUE};
        int[] expected = {Integer.MAX_VALUE, -75, 23462, 42, 2, Integer.MIN_VALUE};

        example.reverse(array);
        assertArrayEquals(expected, array);
    }


    @Test
    public void reverse_OneElementArray() {
        int[] array = {1};
        int[] expected = {1};
        example.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void reverse_EmptyArray() {
        int[] array = {};
        int[] expected = {};
        example.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void reverse_NullArray() {
        assertThrows(IllegalArgumentException.class, () -> example.reverse(null));
    }
}