package faang.school.godbless.sprint3.lambdas.calculator;

import faang.school.godbless.sprint3.lambdas.calculator.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppTest {
    @ParameterizedTest
    @DisplayName("Проверка на верное значение при умножении")
    @MethodSource("generateArrayForProduct")
    void product_CorrectAnswerTest(int expected, List<Integer> list) {
        int result = App.product(list);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("Проверка на верное значение при сложении")
    @MethodSource("generateArrayForSum")
    void sum_CorrectAnswerTest(int expected, List<Integer> list) {
        int result = App.sum(list);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Пустой лист")
    void calculate_EmptyList() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> App.sum(Collections.emptyList()));
        assertEquals(App.ARRAY_IS_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("List is null")
    void calculate_ListIsNull(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> App.sum(null));
        assertEquals(App.ARRAY_IS_NULL_EXCEPTION_MESSAGE, exception.getMessage());
    }

    private static Stream<Arguments> generateArrayForProduct() {
        List<Arguments> listWithArguments = List.of(
                Arguments.of(48, List.of(2, 4, 6)),
                Arguments.of(1, List.of(1)),
                Arguments.of(8, List.of(2, 4))
        );
        return listWithArguments.stream();
    }

    private static Stream<Arguments> generateArrayForSum() {
        List<Arguments> listWithArguments = List.of(
                Arguments.of(12, List.of(2, 4, 6)),
                Arguments.of(1, List.of(1)),
                Arguments.of(6, List.of(2, 4))
        );
        return listWithArguments.stream();
    }
}