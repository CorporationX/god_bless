package school.faang.BJS2_38362_PI;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public boolean isInsideCircle(double radius) {
        return x * x + y * y <= radius * radius;
    }
}
