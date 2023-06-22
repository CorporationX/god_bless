package csv;

import faang.school.godbless.csv.CSV;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVTest {
  @Test
  public void toCsvTest() {
    String expectedResult = "1, 2, 3, 4, 5\n" +
        "6, 7, 8, 9, 10\n" +
        "11, 12, 13, 14, 15\n" +
        "16, 17, 18, 19, 20\n" +
        "21, 22, 23, 24, 25";

    assertEquals(expectedResult, CSV.toCsv(
        List.of(
            List.of("1", "2", "3", "4", "5"),
            List.of("6", "7", "8", "9", "10"),
            List.of("11", "12", "13", "14", "15"),
            List.of("16", "17", "18", "19", "20"),
            List.of("21", "22", "23", "24", "25")
        )
    ));
  }
}
