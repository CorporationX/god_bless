package Sprint_3_Task13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {


    @Test
    void toCsvTest() {
        List<List<String>> list1 =List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );
        String list = """
            1, 2, 3, 4, 5
            6, 7, 8, 9, 10
            11, 12, 13, 14, 15
            16, 17, 18, 19, 20
            21, 22, 23, 24, 25
            """;
        assertEquals(list,Main.toCsv(list1));
    }

}
