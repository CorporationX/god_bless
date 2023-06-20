package faang.school.godbless.sprint3.BuildCSV;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class AppTest {

    @ParameterizedTest
    @MethodSource("getMatrix")
    @DisplayName("Проверка на правильный вывод")
    void toCsv_CorrectAnswerTest(String expected, List<List<String>> matrix) {
        String result = App.toCsv(matrix);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Empty List")
    void toCsv_EmptyListTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> App.toCsv(Collections.emptyList()));
        Assertions.assertEquals(App.LIST_IS_EMPTY_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("Null List")
    void toCsv_NullListTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> App.toCsv(null));
        Assertions.assertEquals(App.LIST_IS_NULL_ERROR_MESSAGE, exception.getMessage());
    }

    private static Stream<Arguments> getMatrix() {
        List<Arguments> arguments = List.of(
                Arguments.of("""
                                1, 2, 3, 4, 5
                                6, 7, 8, 9, 10
                                11, 12, 13, 14, 15
                                16, 17, 18, 19, 20
                                21, 22, 23, 24, 25""",
                        List.of(
                                List.of("1", "2", "3", "4", "5"),
                                List.of("6", "7", "8", "9", "10"),
                                List.of("11", "12", "13", "14", "15"),
                                List.of("16", "17", "18", "19", "20"),
                                List.of("21", "22", "23", "24", "25"))
                ));
        return arguments.stream();
    }
}