package buildCSV;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class testBuild {
    @Test
    public void shouldReturnCorrectString() {
        String actualString = buildCSV.toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        String expectedString = "1, 2, 3, 4, 5\n6, 7, 8, 9, 10\n11, 12, 13, 14, 15\n16, 17, 18, 19, 20\n21, 22, 23, 24, 25";

        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> buildCSV.toCsv(new LinkedList<>()));
    }
}
