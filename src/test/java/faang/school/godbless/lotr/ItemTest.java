package faang.school.godbless.lotr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {

    @Test
    void testConstructor_ShouldThrowException_IfNameIsEmpty() {
        String message = "Name can't be empty.";

        assertThrows(IllegalArgumentException.class, () -> new Item(" ", 1), message);
    }

    @Test
    void testConstructor_ShouldThrowException_IfValueIsLessThanZero() {
        String message = "Value can't be less then zero";

        assertThrows(IllegalArgumentException.class, () -> new Item("Donut", -1), message);
    }
}
