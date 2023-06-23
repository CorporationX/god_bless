package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FormatterTest {
    Formatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new Formatter();
    }

    @Test
    void testtoCsv() throws IllegalAccessException {
        System.out.println(
                formatter.toCsv(
                        List.of(
                                List.of("1", "2", "3", "4", "5"),
                                List.of("6", "7", "8", "9", "10"),
                                List.of("11", "12", "13", "14", "15"),
                                List.of("16", "17", "18", "19", "20"),
                                List.of("21", "22", "23", "24", "25")
                        )
                )
        );
    }
}