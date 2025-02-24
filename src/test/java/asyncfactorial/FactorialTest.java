package asyncfactorial;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Nested
    class FactorialIntTests {
        @Test
        void factorialIntZeroShouldReturnOne() {
            assertEquals(1, Factorial.factorialInt(0));
        }

        @Test
        void factorialIntPositiveValue() {
            assertEquals(120, Factorial.factorialInt(5));
        }

        @Test
        void factorialIntMaxBoundary() {
            assertEquals(479001600, Factorial.factorialInt(12));
        }

        @Test
        void factorialIntBelowZeroShouldThrowException() {
            assertThrows(IllegalArgumentException.class, () -> Factorial.factorialInt(-1));
        }

        @Test
        void factorialIntAboveMaxShouldThrowException() {
            assertThrows(IllegalArgumentException.class, () -> Factorial.factorialInt(13));
        }
    }

    @Nested
    class FactorialLongTests {
        @Test
        void factorialLongWithinRange() {
            assertEquals(6227020800L, Factorial.factorialLong(13));
        }

        @Test
        void factorialLongMaxBoundary() {
            assertEquals(121645100408832000L, Factorial.factorialLong(19));
        }

        @Test
        void factorialLongBelowOrEqualIntBoundaryUsesIntMethod() {
            int n = 10;
            assertEquals(Factorial.factorialInt(n), Factorial.factorialLong(n));
        }

        @Test
        void factorialLongBelowMinRangeShouldUseInt() {
            assertEquals(479001600, Factorial.factorialLong(12));
        }

        @Test
        void factorialLongAboveMaxShouldThrowException() {
            assertThrows(IllegalArgumentException.class, () -> Factorial.factorialLong(20));
        }

        @Test
        void factorialLongNegativeShouldThrowException() {
            assertThrows(IllegalArgumentException.class, () -> Factorial.factorialLong(-5));
        }
    }

    @Nested
    class FactorialBigTests {
        @Test
        void factorialBigWithinRangeForBigInteger() {
            BigInteger expected = new BigInteger("2432902008176640000");
            assertEquals(expected, Factorial.factorialBig(20));
        }

        @Test
        void factorialBigForLowerValuesUsesLongCalculation() {
            int n = 15;
            assertEquals(BigInteger.valueOf(Factorial.factorialLong(n)), Factorial.factorialBig(n));
        }

        @Test
        void factorialBigNegativeShouldThrowException() {
            List<CompletableFuture<BigInteger>> futures = Factorial.factorials(List.of(-1));
            CompletableFuture<BigInteger> future = futures.get(0);
            CompletionException exception = assertThrows(CompletionException.class, future::join);
            assertTrue(exception.getCause() instanceof IllegalArgumentException);
        }
    }

    @Nested
    class AsynchronousFactorialsTests {
        @Test
        void factorialsListShouldComputeCorrectResults() {
            List<Integer> numbers = List.of(5, 12, 15, 20, 25);
            List<CompletableFuture<BigInteger>> futures = Factorial.factorials(numbers);

            BigInteger[] expected = {
                    BigInteger.valueOf(120),
                    BigInteger.valueOf(479001600),
                    BigInteger.valueOf(1307674368000L),
                    new BigInteger("2432902008176640000"),
                    Factorial.factorialBig(25)
            };

            for (int i = 0; i < numbers.size(); i++) {
                BigInteger result = futures.get(i).join();
                assertEquals(expected[i], result, "Factorial for " + numbers.get(i) + " is incorrect.");
            }
        }

        @Test
        void factorialsListShouldFailForNegativeNumber() {
            List<Integer> numbers = List.of(5, -3, 10);
            List<CompletableFuture<BigInteger>> futures = Factorial.factorials(numbers);

            CompletableFuture<BigInteger> negativeFuture = futures.get(1);
            Exception exception = assertThrows(Exception.class, negativeFuture::join);
            assertTrue(exception.getCause() instanceof IllegalArgumentException);
        }
    }
}
