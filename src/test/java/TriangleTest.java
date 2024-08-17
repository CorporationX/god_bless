
import faang.school.godbless.triangle.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TriangleTest {
    @Test
    public void triangleAreaTest() {
        Main main = new Main();
        double[] list = new double[3];
        list[0] = 5; list[1] = 6; list[2] = 7;

        double received = main.triangleArea(list[0], list[1], list[2]);
        Assertions.assertEquals(received, tA(list));
    }

    //тест на то, что передаваемые в функцию значения правильно прохдят валидацию
    @Test
    public void triangleAreaExceptionTest() {
        Main main = new Main();

        double[] list = new double[3];
        list[0] = 100; list[1] = 10; list[2] = 5;

        Throwable throwable = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> main.triangleArea(list[0], list[1], list[2])
        );
        Assertions.assertEquals("There is no such triangle", throwable.getMessage());


        list[0] = 1; list[1] = 1; list[2] = -1;

        Throwable throwable1 = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> main.triangleArea(list[0], list[1], list[2])
        );
        Assertions.assertEquals("There is no such triangle", throwable1.getMessage());
    }

    //чисто свойский метод, чтобы по своему площадь посчитать и сравнить значения
    private double tA(double[] list) {
        double p = Arrays.stream(list).sum()/2d;
        return Math.sqrt(
                p*(p-list[0])*(p-list[1])*(p-list[2])
        );
    }
}
