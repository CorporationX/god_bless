import faang.school.godbless.rememberSchool.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void triangleAreaTest() {
        double test = Main.triangleArea(3, 4, 5);
        double expected = 6.0;
        assertEquals(expected, test);
    }
}
