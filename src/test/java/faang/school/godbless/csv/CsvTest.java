package faang.school.godbless.csv;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvTest {
    @Test
    void toCsvTest() {
        List<List<String>> table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );
        String exceptedCSV = ("1, 2, 3, 4, 5," +
                "\n6, 7, 8, 9, 10," +
                "\n11, 12, 13, 14, 15," +
                "\n16, 17, 18, 19, 20," +
                "\n21, 22, 23, 24, 25");
        assertEquals(exceptedCSV, Csv.toCsv(table));
    }
}