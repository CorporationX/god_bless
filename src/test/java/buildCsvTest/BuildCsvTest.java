package buildCsvTest;

import faang.school.godbless.buildCSV.BuildCSV;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuildCsvTest {

    @Test
    public void testToCsv() {
        String expected = """
                1, 2, 3, 4, 5
                6, 7, 8, 9, 10
                """;
        String result = BuildCSV.toCsv(List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10")
        ));

        assertEquals(expected, result);
    }

    @Test
    public void testToCsvIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           BuildCSV.toCsv(List.of(List.of()));
        });
        String expectedMessage = "empty list";
        String resultMessage = exception.getMessage();
        assertEquals(resultMessage, expectedMessage);
    }
}
