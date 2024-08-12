package faang.school.godbless.bjs2_21427;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testCalculate() {
        var result1 = Main.calculate(List.of(1, 2), (a, b) -> a * b);
        assertEquals(2, result1);

        var result2 = Main.calculate(List.of(1, 2, 3), (a, b) -> a * b);
        assertEquals(6, result2);

        var result3 = Main.calculate(List.of(1, 2), Integer::sum);
        assertEquals(3, result3);

        var result4 = Main.calculate(List.of(1, 2, 3), Integer::sum);
        assertEquals(6, result4);
    }

    @Test
    void testProduct() {
        var result0 = Main.product(List.of(1));
        assertEquals(1, result0);

        var result1 = Main.product(List.of(1, 2));
        assertEquals(2, result1);

        var result2 = Main.product(List.of(1, 2, 3));
        assertEquals(6, result2);
    }

    @Test
    void testSum() {
        var result0 = Main.sum(List.of(1));
        assertEquals(1, result0);

        var result1 = Main.sum(List.of(1, 2));
        assertEquals(3, result1);

        var result2 = Main.sum(List.of(1, 2, 3));
        assertEquals(6, result2);
    }
}