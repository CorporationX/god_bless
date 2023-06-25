package faang.school.godbless;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static faang.school.godbless.Application.product;
import static faang.school.godbless.Application.sum;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("productTestDataProvider")
    public void productTest(List<Integer> nums, int expectedProduct){
        int actualProduct = product(nums);
        assertEquals(expectedProduct, actualProduct);
    }

    @ParameterizedTest
    @MethodSource("sumTestDataProvider")
    public void sumTest(List<Integer> nums, int expectedSum){
        int actualSum = sum(nums);
        assertEquals(expectedSum, actualSum);
    }


    static Stream<Arguments> productTestDataProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), 24),
                Arguments.of(List.of(5, 6, 7), 210),
                Arguments.of(List.of(10, 2, 1), 20)
        );
    }
    static Stream<Arguments> sumTestDataProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), 10),
                Arguments.of(List.of(5, 6, 7), 18),
                Arguments.of(List.of(10, 2, 1), 13)
        );
    }
}