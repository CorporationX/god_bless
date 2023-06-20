import org.junit.jupiter.api.Test;

import static faang.school.godbless.Application.triangleArea;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    @Test
    void triangleAreaTest() {
        double a = 3;
        double b = 3;
        double c = 3;
        double p = (3.0 + 3.0 + 3.0) / 2.0;

        double expected = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double actual = triangleArea(a, b, c);

        assertEquals(expected,actual);
    }
}
