package school.faang.module4.factorial;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    private static final String FIFTY_FACTORIAL_VALUE =
            "30414093201713378043612608166064768844377641568960512000000000000";
    private static final String ONE_HUNDRED_FACTORIAL_VALUE =
            "93326215443944152681699238856266700490715968264381621468592963895217599993229915608" +
                    "941463976156518286253697920827223758251185210916864000000000000000000000000";

    @ParameterizedTest
    @MethodSource("provideFactorialIntParameters")
    public void testFactorialInt(int n, int expected) {
        int actual = Factorial.factorialInt(n);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideFactorialLongParameters")
    public void testFactorialLong(int n, long expected) {
        long actual = Factorial.factorialLong(n);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideFactorialBigParameters")
    public void testFactorialBig(int n, BigInteger expected) {
        BigInteger actual = Factorial.factorialBig(n);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> provideFactorialIntParameters() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(12, 479_001_600)
        );
    }

    public static Stream<Arguments> provideFactorialLongParameters() {
        return Stream.of(
                Arguments.of(4, 24L),
                Arguments.of(13, 6_227_020_800L),
                Arguments.of(15, 1_307_674_368_000L),
                Arguments.of(19, 121_645_100_408_832_000L)
        );
    }

    public static Stream<Arguments> provideFactorialBigParameters() {
        return Stream.of(
                Arguments.of(20, new BigInteger("2432902008176640000")),
                Arguments.of(25, new BigInteger("15511210043330985984000000")),
                Arguments.of(50, new BigInteger(FIFTY_FACTORIAL_VALUE)),
                Arguments.of(100, new BigInteger(ONE_HUNDRED_FACTORIAL_VALUE))
        );
    }
}
