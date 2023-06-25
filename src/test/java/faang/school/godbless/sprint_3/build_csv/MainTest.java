package faang.school.godbless.sprint_3.build_csv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void toCsv_Test() {
        List<List<String>> listOfLists = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );
        String expected = """
                1 ,2 ,3 ,4 ,5
                6 ,7 ,8 ,9 ,10
                11 ,12 ,13 ,14 ,15
                16 ,17 ,18 ,19 ,20
                21 ,22 ,23 ,24 ,25""";
        String result = Main.toCsv(listOfLists);

        assertFalse(result.isEmpty());
        assertEquals(expected, result);
    }

    @Test
    void toCsv_ThrowsIllegalArgumentException() {
        List<List<String>> secondListOfLists = List.of(
                List.of(),
                List.of()
        );

        assertThrows(IllegalArgumentException.class, () -> Main.toCsv(new ArrayList<>()));
        assertThrows(IllegalArgumentException.class, () -> Main.toCsv(secondListOfLists));
    }
}