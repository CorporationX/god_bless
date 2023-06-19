package faang.school.godbless.task.csv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    private static Stream<Arguments> getList() {
        return Stream.of(
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
    }
    private static Stream<Arguments> getListWithEmptyLine() {
        return Stream.of(
                Arguments.of("""
                                1, 2, 3, 4, 5
                                6, 7, 8, 9, 10
                                16, 17, 18, 19, 20
                                21, 22, 23, 24, 25""",
                        List.of(
                                List.of("1", "2", "3", "4", "5"),
                                List.of("6", "7", "8", "9", "10"),
                                List.of(),
                                List.of("16", "17", "18", "19", "20"),
                                List.of("21", "22", "23", "24", "25"))
                ));
    }

    @Test
    void toCsv_shouldThrowIllegalArgumentExceptionWithNull() {
        assertThrows(IllegalArgumentException.class, () -> Main.toCsv(null));
    }

    @Test
    void toCsv_shouldReturnEmptyStringWithEmptyList() {
        var strFromEmptyList = Main.toCsv(List.of());
        assertEquals("", strFromEmptyList);

        var strFromEmptyListOfEmptyList = Main.toCsv(List.of(new ArrayList<>()));
        assertEquals("", strFromEmptyListOfEmptyList);

        var strFromEmptyListOfEmptyLists = Main.toCsv(List.of(new ArrayList<>(), new ArrayList<>()));
        assertEquals("", strFromEmptyListOfEmptyLists);
    }

    @Test
    void toCsv_shouldReturnEmptyStringWithNullAndEmptySubLists() {
        List<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(null);
        lists.add(new ArrayList<>());
        lists.add(null);

        List<String> s = List.of("");

        var strFromListWithEmptyAndNullLists = Main.toCsv(lists);
        assertEquals("", strFromListWithEmptyAndNullLists);
    }

    @ParameterizedTest
    @MethodSource("getList")
    void toCsv_shouldReturnCorrectString(String expected, List<List<String>> lists) {
        var result = Main.toCsv(lists);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("getListWithEmptyLine")
    void toCsv_shouldReturnCorrectStringWithEmptyLineInside(String expected, List<List<String>> lists) {
        var result = Main.toCsv(lists);

        assertEquals(expected, result);
    }
}