package faang.school.godbless.csv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CSVConverterTest {

    @Test
    void toCsvValidTest() {
        List<List<String>> table = List.of(
            List.of("1", "2", "3", "4", "5"),
            List.of("6", "7", "8", "9", "10"),
            List.of("11", "12", "13", "14", "15"),
            List.of("16", "17", "18", "19", "20"),
            List.of("21", "22", "23", "24", "25")
        );

        String expected = """
            1, 2, 3, 4, 5
            6, 7, 8, 9, 10
            11, 12, 13, 14, 15
            16, 17, 18, 19, 20
            21, 22, 23, 24, 25""";

        String actual = CSVConverter.toCsv(table);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getEmptyAndNullableTable")
    void toCsvEmptyAndNullableTableTest(List<List<String>> table) {
        assertThrows(Exception.class, () -> CSVConverter.toCsv(table));
    }

    private static Stream<List<List<String>>> getEmptyAndNullableTable() {
        return Stream.of(
            null,
            Collections.emptyList(),
            Collections.singletonList(Collections.emptyList())
        );
    }
}