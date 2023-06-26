package faang.school.godbless.csv;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class AppTest {

    @Test
    public void testToCsvValidInput() {
        List<List<String>> table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String expectedCsv = "1, 2, 3, 4, 5\n" +
                "6, 7, 8, 9, 10\n" +
                "11, 12, 13, 14, 15\n" +
                "16, 17, 18, 19, 20\n" +
                "21, 22, 23, 24, 25\n";

        String actualCsv = App.toCsv(table);

        assertEquals(expectedCsv, actualCsv);
    }

    @Test
    public void testToCsvEmptyTable() {
        List<List<String>> table = List.of();

        assertThrows(IllegalArgumentException.class, () -> App.toCsv(table));
    }

    @Test
    public void testToCsvEmptyRow() {
        List<List<String>> table = List.of(
                List.of("1", "2", "3"),
                List.of(),
                List.of("4", "5", "6")
        );

        assertThrows(IllegalArgumentException.class, () -> App.toCsv(table));
    }

    @Test
    public void testToCsvNullTable() {
        assertThrows(NullPointerException.class, () -> App.toCsv(null));
    }

}