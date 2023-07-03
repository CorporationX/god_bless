package faang.school.godbless.sprint3.task2;

import faang.school.godbless.sprint3.lambda.task2.CSV;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @Test
    void testToCsv() {
        List<List<String>> matrix = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );
        String expected = "1, 2, 3, 4, 5\n" +
                "6, 7, 8, 9, 10\n" +
                "11, 12, 13, 14, 15\n" +
                "16, 17, 18, 19, 20\n" +
                "21, 22, 23, 24, 25";

        String actual = CSV.toCsv(matrix);

        assertEquals(expected, actual);
    }

    @Test
    void testListEmpty() {
        List<List<String>> matrix = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> CSV.toCsv(matrix));
    }
    @Test
    void testListNull() {
        assertThrows(NullPointerException.class, () -> CSV.toCsv(null));
    }

    @Test
    void testVectorEmpty() {
        assertThrows(IllegalArgumentException.class, () -> CSV.toCsv(List.of(List.of())));
    }
    @Test
    void testVectorNull() {
        List<List<String>> matrix = new ArrayList<>();
        matrix.add(List.of("1"));
        matrix.add(null);
        matrix.add(List.of("1"));
        assertThrows(IllegalArgumentException.class, () -> CSV.toCsv(List.of(List.of())));
    }
}