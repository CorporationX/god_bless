package sprint3.csv;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatrixJoinerTest {

    @Test
    void toCsv() {
        String expected = """
                1, 2, 3, 4, 5
                6, 7, 8, 9, 10
                11, 12, 13, 14, 15
                16, 17, 18, 19, 20
                21, 22, 23, 24, 25""";

        assertEquals(expected, MatrixJoiner.toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        ));
    }

    @Test
    void toCsv_shouldThrowsIAException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> MatrixJoiner.toCsv(Collections.emptyList()),
                "Empty list");
    }
}