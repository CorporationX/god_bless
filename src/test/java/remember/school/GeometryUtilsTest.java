package remember.school;

import faang.school.godbless.remember.school.GeometryUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeometryUtilsTest {

    private static final double SIDE_A = 1d;
    private static final double SIDE_B = 1d;
    private static final double SIDE_C = 1.8d;
    private static final double CALCULATED_AREA = 0.392d;
    private static final double EPSILON = 0.001d;

    @Test
    void testTriangleAreaWithExceptions() {
        IllegalArgumentException moreThanZeroException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> GeometryUtils.triangleArea(0, 1, 1));
        Assertions.assertEquals("A side should be more than zero", moreThanZeroException.getMessage());

        IllegalArgumentException wrongLengthException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> GeometryUtils.triangleArea(1, 2, 5));
        Assertions.assertEquals("Wrong lengths. It's impossible to create triangle with such sides", wrongLengthException.getMessage());
    }

    @Test
    void testTriangleArea() {
        Assertions.assertTrue(Math.abs(CALCULATED_AREA - GeometryUtils.triangleArea(SIDE_A, SIDE_B, SIDE_C)) < EPSILON);
    }
}
