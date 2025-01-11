package school.faang.bjs250340;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

class FactorialTest {

    private static final Logger log = LoggerFactory.getLogger(FactorialTest.class);

    @Test
    public void factorialInt() {
        Assertions.assertEquals(120, Factorial.factorialInt(5));
        Assertions.assertEquals(479001600, Factorial.factorialInt(12));

        try {
            Factorial.factorialInt(13);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("n > MAX_INT_FACTORIAL", e.getMessage());
        }
    }

    @Test
    public void factorialLong() {
        Assertions.assertEquals(6227020800L, Factorial.factorialLong(13));
        Assertions.assertEquals(121645100408832000L, Factorial.factorialLong(19));
    }

    @Test
    public void factorialBigInt() {
        Assertions.assertEquals(new BigInteger("46225138155356160000"), Factorial.factorialBig(20));
    }

    @Test
    public void factorials() {
        Factorial.factorials(List.of(20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)).forEach(c -> {
            try {
                BigInteger n = c.get();
                System.out.println(n);
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage());
            }
        });
    }
}