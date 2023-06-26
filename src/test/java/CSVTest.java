import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CSVTest {
    @Test
    void printTest() {
        String str = CSV.toCsv(List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        ));

        System.out.println(str);
    }

    @Test
    void IllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> CSV.toCsv(List.of(List.of())));
    }
}