package faang.school.godbless.csv_builder;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CsvBuilderTest {

    @Test
    void testToCsv_ShouldThrowException_IfMainListIsEmpty() {
        List<List<String>> list = new ArrayList<>();
        String message = "List can't be empty";

        assertThrows(IllegalArgumentException.class, () -> new CsvBuilder().toCsv(list), message);
    }

    @Test
    void testToCsv_ShouldThrowException_IfOneOfInnerListsAreEmpty() {
        List<List<String>> list = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of(),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String message = "List can't be empty";

        assertThrows(IllegalArgumentException.class, () -> new CsvBuilder().toCsv(list), message);
    }

    @Test
    void testToCsv_ShouldConvert2dListOfStrings_InToStringCsvRepresentation() {
        CsvBuilder builder = new CsvBuilder();
        String actualOutput = builder.toCsv(List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        String expectedOutput = "1, 2, 3, 4, 5\n" +
                "6, 7, 8, 9, 10\n" +
                "11, 12, 13, 14, 15\n" +
                "16, 17, 18, 19, 20\n" +
                "21, 22, 23, 24, 25";

        assertEquals(expectedOutput, actualOutput);
    }
}
