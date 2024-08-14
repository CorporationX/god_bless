package faang.school.godbless.lambda.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeometryTest {

    @Test
    void testTriangleArea_EqualsSides() {
        Double area = Geometry.triangleArea(3, 3, 3);
        assertEquals(3.897114317029974, area);
    }

    @Test
    void testTriangleArea_DiffSides() {
        Double area = Geometry.triangleArea(2, 4, 4.472135954999579392);
        assertEquals(4, area);
    }

    @Test
    void testTriangleArea_NotExist() {
        assertThrows(IllegalArgumentException.class, () -> Geometry.triangleArea(30, 60, 8));
    }

    @Test
    void testTriangleArea_OneSideZero() {
        assertThrows(IllegalArgumentException.class, () -> Geometry.triangleArea(0, 1, 1));
    }
}