package school;

import faang.school.godbless.school.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
  @Test
  public void triangleAreaTest() {
    int a = 10;
    int b = 8;
    int c = 12;

    double p = (a + b + c ) / 2.0;
    double expectedArea = Math.sqrt(p*(p-a)*(p-b)*(p-c));

    Triangle triangle = new Triangle();

    assertEquals(expectedArea, triangle.triangleArea(a,b,c));
  }
}
