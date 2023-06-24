package faang.school.godbless.sprint3.School;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.sprint3.School.Main.triangleArea;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testTriangleAreaTrue() {
        assertEquals(6.0,triangleArea(3,4,5));
    }

    @Test
    void testTriangleAreaError(){
        IllegalArgumentException err = assertThrows(IllegalArgumentException.class, ()->triangleArea(1,1,5));
        assertEquals("triangle is not exist", err.getMessage());
    }
}