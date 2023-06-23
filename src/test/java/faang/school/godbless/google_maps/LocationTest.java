package faang.school.godbless.google_maps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocationTest {

    @Test
    void testLocationConstructor_ShouldThrowException_IfNameIsEmpty() {
        String message = "Name can't be empty";

        assertThrows(IllegalArgumentException.class, () -> new Location(" ", 12.1123, -2), message);
    }
}
