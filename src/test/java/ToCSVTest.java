import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static faang.school.godbless.buildCSV.ToCSV.toCSV;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToCSVTest {
    List<List<String>> list;

    @BeforeEach
    public void init() {
        list = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10")
        );
    }

    @Test
    public void toCSVTest() {
        String result = toCSV(list);
        String expected = "1, 2, 3, 4, 5" + "\n" + "6, 7, 8, 9, 10";
        assertEquals(expected, result);
    }
}
