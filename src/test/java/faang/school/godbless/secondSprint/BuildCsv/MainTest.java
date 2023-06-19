package faang.school.godbless.secondSprint.BuildCsv;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testToCsvReturnCorrectString() {
        String result1 = Main.toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15")
                )
        );
        String expected1 = "1, 2, 3, 4, 5\n6, 7, 8, 9, 10\n11, 12, 13, 14, 15";
        String result2 = Main.toCsv(
                List.of(
                        List.of("1"),
                        List.of("0", "0", "8", "0", "0")
                )
        );
        String expected2 = "1\n0, 0, 8, 0, 0";

        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
    }

    @Test
    public void testToCsvThrowExc() {
        assertThrows(IllegalArgumentException.class, () -> Main.toCsv(List.of(List.of())));
    }
}