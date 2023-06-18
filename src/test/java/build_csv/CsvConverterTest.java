package build_csv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CsvConverterTest {

    @Test
    public void testToCsv() {
        List<List<String>> table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String expectedCsv = """
                1, 2, 3, 4, 5
                6, 7, 8, 9, 10
                11, 12, 13, 14, 15
                16, 17, 18, 19, 20
                21, 22, 23, 24, 25""";

        String actualCsv = CsvConverter.toCsv(table);

        Assertions.assertEquals(expectedCsv, actualCsv);
    }

    @Test
    public void testToCsvEmptyTable() {
        List<List<String>> table = List.of();

        Assertions.assertThrows(IllegalArgumentException.class, () -> CsvConverter.toCsv(table));
    }

    @Test
    public void testToCsvNullTable() {
        List<List<String>> table = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> CsvConverter.toCsv(table));
    }

}