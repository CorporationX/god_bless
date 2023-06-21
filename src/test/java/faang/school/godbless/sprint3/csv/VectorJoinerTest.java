package faang.school.godbless.sprint3.csv;


import faang.school.godbless.sprint3.csv.VectorJoiner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VectorJoinerTest {

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(List.of("1", "2", "3", "4", "5", "6"), "1, 2, 3, 4, 5, 6"),
                Arguments.of(List.of("q", "w", "e", "r", "t"), "q, w, e, r, t")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void toCsv_shouldMatch(List<String> vector, String expected) {

        assertEquals(expected, VectorJoiner.toCsv(vector));
    }

    @Test
    void toCsv_shouldThrowsIAException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> VectorJoiner.toCsv(Collections.emptyList()),
                "Empty list");
    }
}