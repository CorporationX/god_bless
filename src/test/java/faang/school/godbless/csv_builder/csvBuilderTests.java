package faang.school.godbless.csv_builder;

import faang.school.godbless.build_a_csv.CSVBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class csvBuilderTests {

    CSVBuilder csvBuilder = new CSVBuilder();

    @Test
    @DisplayName("Should build a csv")
    void shouldBuildACSV() {

        String expectedOutput = "1, 2, 3, 4, 5\n" +
                                "6, 7, 8, 9, 10\n" +
                                "11, 12, 13, 14, 15\n" +
                                "16, 17, 18, 19, 20\n" +
                                "21, 22, 23, 24, 25";

        List<List<String>> table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        Assertions.assertEquals(expectedOutput, csvBuilder.toCsv(table));
    }
}
