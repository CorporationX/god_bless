package school.faang.bjs_47121;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListOperations2Test {

    public static Stream<Arguments> getNumbersAndSum() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7,
                        Map.of(1, 6, 2, 5, 3, 4))
        );
    }

    public static Stream<Arguments> getCountries() {
        return Stream.of(
                Arguments.of(Map.of("Russia", "Moscow", "USA", "Washington",
                        "Germany", "Berlin"), Arrays.asList("Berlin", "Moscow", "Washington"))
        );
    }

    @ParameterizedTest
    @MethodSource("getNumbersAndSum")
    void getPairOfNumbers(List<Integer> numbers, int sum, Map<Integer, Integer> expected) {
        assertEquals(expected, ListOperations2.getPairOfNumbers(numbers, sum));
    }

    @ParameterizedTest
    @MethodSource("getCountries")
    void getCapitals(Map<String, String> countries, List<String> expected) {
        assertEquals(expected, ListOperations2.getCapitals(countries));
    }
}