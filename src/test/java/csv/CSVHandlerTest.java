package csv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CSVHandlerTest {
    @Test
    public void shouldReturnStringFromCSVFormat() {
        String expectedString = "Mark, 20, Omsk, M\nKlara, 21, Chili, W";
        List<List<String>> table = getTable();

        String actualString = CSVHandler.toCsv(table);

        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CSVHandler.toCsv(new ArrayList<>()));
    }

    private List<List<String>> getTable() {
        return List.of(
                List.of("Mark", "20", "Omsk", "M"),
                List.of("Klara", "21", "Chili", "W")
        );
    }
}
