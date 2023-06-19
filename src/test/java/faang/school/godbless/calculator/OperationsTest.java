package faang.school.godbless.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {
    @ParameterizedTest
    @MethodSource("prepareArgumentsForProduct")
    void testProduct(List<Integer> nums, int expected) {
        assertEquals(expected, Operations.product(nums));
    }

    @ParameterizedTest
    @MethodSource("prepareArgumentsForProduct")
    void testProductUseStream(List<Integer> nums, int expected) {
        assertEquals(expected, Operations.productUseStream(nums));
    }

    @ParameterizedTest
    @MethodSource("prepareArgumentsForSum")
    void testSum(List<Integer> nums, int expected) {
        assertEquals(expected, Operations.sum(nums));
    }

    @ParameterizedTest
    @MethodSource("prepareArgumentsForSum")
    void testSumUseStream(List<Integer> nums, int expected) {
        assertEquals(expected, Operations.sumUseStream(nums));
    }


    @Test
    void shouldThrowException(){
        List<Integer> nums = null;
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> Operations.sum(nums)),
                () -> assertThrows(IllegalArgumentException.class, () -> Operations.product(nums)),
                () -> assertThrows(IllegalArgumentException.class, () -> Operations.sumUseStream(nums)),
                () -> assertThrows(IllegalArgumentException.class, () -> Operations.productUseStream(nums))
        );
    }

    static Stream<Arguments> prepareArgumentsForProduct() {
        return Stream.of(
                Arguments.of(List.of(5, 10, 10, 2), 1000),
                Arguments.of(List.of(-5, 10, 10, 2), -1000),
                Arguments.of(List.of(), 0)
        );
    }

    static Stream<Arguments> prepareArgumentsForSum() {
        return Stream.of(
                Arguments.of(List.of(5, 10, 10, 2), 27),
                Arguments.of(List.of(-5, 10, 10, 2), 17),
                Arguments.of(List.of(), 0)
        );
    }

}