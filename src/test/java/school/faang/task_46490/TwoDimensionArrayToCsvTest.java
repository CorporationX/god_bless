package school.faang.task_46490;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoDimensionArrayToCsvTest {

    @Test
    void testToCsvSpecificCase() {
        List<List<String>> data = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String expected =
                "1, 2, 3, 4, 5\n6, 7, 8, 9, 10\n11, 12, 13, 14, 15\n16, 17, 18, 19, 20\n21, 22, 23, 24, 25\n";
        String actual = TwoDimensionArrayToCsv.toCsv(data);

        assertEquals(expected, actual);
    }
}