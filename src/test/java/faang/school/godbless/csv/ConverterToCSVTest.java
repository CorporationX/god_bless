package faang.school.godbless.csv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterToCSVTest {
    private List<List<String>> table;

    @BeforeEach
    void setUp() {
        table = new ArrayList<>();
    }

    @Test
    void testToCsv() {
        String expectedString = """
                1, 2, 3, 4, 5
                6, 7, 8, 9, 10
                11, 12, 13, 14, 15
                16, 17, 18, 19, 20
                21, 22, 23, 24, 25""";

       table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        assertEquals(expectedString, ConverterToCSV.toCsv(table));
    }

    @Test
    void shouldThrowExceptionByEmptyTable() {
        Exception exc = assertThrows(IllegalArgumentException.class, ()->ConverterToCSV.toCsv(table));
        assertEquals("Empty matrix", exc.getMessage());
    }

    @Test
    void shouldThrowExceptionByEmptyRow() {
        table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of(),
                List.of("1", "2", "3", "4", "5")
        );
        Exception exc = assertThrows(IllegalArgumentException.class, ()->ConverterToCSV.toCsv(table));
        assertEquals("Empty list", exc.getMessage());
    }
}