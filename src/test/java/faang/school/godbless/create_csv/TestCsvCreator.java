package faang.school.godbless.create_csv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCsvCreator {

    private List<List<String>> list;

    @BeforeEach
    public void setUp() {
        list = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );
    }

    @Test
    public void testVectorJoiner() {
        System.out.println(CsvCreator.toCsv(list));
    }
}
