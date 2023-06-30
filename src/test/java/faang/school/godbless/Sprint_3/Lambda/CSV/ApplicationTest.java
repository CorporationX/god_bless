package faang.school.godbless.Sprint_3.Lambda.CSV;

import org.junit.jupiter.api.Test;

import java.util.List;

import static faang.school.godbless.Sprint_3.Lambda.CSV.Application.toCSV;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    List<List<String>> table = List.of(
            List.of("1", "2", "3", "4", "5"),
            List.of("6", "7", "8", "9", "10"),
            List.of("11", "12", "13", "14", "15"),
            List.of("16", "17", "18", "19", "20"),
            List.of("21", "22", "23", "24", "25")
    );

    @Test
    public void appTest() {
        String csv = toCSV(table);

        assertEquals(csv, "1, 2, 3, 4, 5\n" +
                "6, 7, 8, 9, 10\n" +
                "11, 12, 13, 14, 15\n" +
                "16, 17, 18, 19, 20\n" +
                "21, 22, 23, 24, 25");
    }
}