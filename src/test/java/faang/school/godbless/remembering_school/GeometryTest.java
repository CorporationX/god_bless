package faang.school.godbless.remembering_school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeometryTest {
    @Test
    void getArea() {
        Geometry geometry = new Geometry();
        assertEquals(2.905, geometry.triangleArea(2, 4, 3));
    }

    @Test
    void testImpossibleTriangle() {
        Geometry geometry = new Geometry();
        assertThrows(IllegalArgumentException.class, () -> geometry.triangleArea(2, 10, 3));
    }
}