package faang.school.godbless.secondSprint.BuildCsv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @MethodSource("listProvider")
    public void testToCsvReturnCorrectString(List<List<String>> table, String expected) {
        assertEquals(expected, Main.toCsv(table));
    }

    static Stream<Arguments> listProvider() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15")),
                        "1, 2, 3, 4, 5\n6, 7, 8, 9, 10\n11, 12, 13, 14, 15"),
                Arguments.of(List.of(
                        List.of("1"),
                        List.of("0", "0", "8", "0", "0")),
                        "1\n0, 0, 8, 0, 0")
                );
    }

    @Test
    public void testToCsvThrowExc() {
        assertThrows(IllegalArgumentException.class, () -> Main.toCsv(List.of(List.of())));
        assertThrows(IllegalArgumentException.class, () -> Main.toCsv(List.of()));
        assertThrows(IllegalArgumentException.class, () -> Main.toCsv(null));
    }
}