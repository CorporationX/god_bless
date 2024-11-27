package school.faang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void sumTest() {
        int res = Main.sum(5, 2);
        assertEquals(7, res);
    }
}
