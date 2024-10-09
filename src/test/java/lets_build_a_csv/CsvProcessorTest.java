package lets_build_a_csv;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvProcessorTest {
    private final List<List<String>> TABLE = List.of(
            List.of("1", "2", "3", "4", "5"),
            List.of("6", "7", "8", "9", "10"),
            List.of("11", "12", "13", "14", "15"),
            List.of("16", "17", "18", "19", "20"),
            List.of("21", "22", "23", "24", "25")
    );

    @Test
    void toCSV() {
        String result = CsvProcessor.toCSV(TABLE);

        assertEquals("1, 2, 3, 4, 5\n6, 7, 8, 9, 10\n11, 12, 13, 14, 15\n16, 17, 18, 19, 20\n21, 22, 23, 24, 25", result);
    }
}