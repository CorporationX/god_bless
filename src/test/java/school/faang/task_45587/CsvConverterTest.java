package school.faang.task_45587;

import org.junit.jupiter.api.Test;
import school.faang.task_46142.CsvConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvConverterTest {

    @Test
    void testSuccessToCsv() {
        var result = CsvConverter.toCsv(
            List.of(
                List.of("1"),
                List.of("6", "7"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
            )
        );

        var stringBuilder = new StringBuilder();
        var expected = stringBuilder
            .append("\n1\n")
            .append("6, 7\n")
            .append("11, 12, 13, 14, 15\n")
            .append("16, 17, 18, 19, 20\n")
            .append("21, 22, 23, 24, 25"
            ).toString();

        assertEquals(expected, result);
    }

    @Test
    void testToCsvThrowException() {
        assertThrows(IllegalArgumentException.class, () -> CsvConverter.toCsv(List.of()));
        assertThrows(IllegalArgumentException.class, () -> CsvConverter.toCsv(List.of(List.of(), List.of())));
        assertThrows(IllegalArgumentException.class, () -> CsvConverter.toCsv(List.of(List.of("1", "2"), List.of())));
    }
}