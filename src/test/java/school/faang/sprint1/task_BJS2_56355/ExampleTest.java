package school.faang.sprint1.task_BJS2_56355;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    private Example example;

    @BeforeEach
    public void setUp() {
        example = new Example();
    }

    @Test
    public void reverse_PositiveTest() {
        String[] array = {"one", "two", "", null, "three"};
        String[] expected = {"three", null, "", "two", "one"};

        example.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void reverse_OneElementArray() {
        String[] array = {"one"};
        String[] expected = {"one"};
        example.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void reverse_EmptyArray() {
        String[] array = {};
        String[] expected = {};
        example.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void reverse_NullArray() {
        assertThrows(IllegalArgumentException.class, () -> example.reverse(null));
    }
}