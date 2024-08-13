package faang.school.godbless.bjs2_20408;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void testTriangleArea() {
        var result = Main.triangleArea(3, 4, 5);
        assertEquals(6, result);

        assertThrows(Exception.class, () -> {
            Main.triangleArea(1, 1, 2);
        });
    }
}