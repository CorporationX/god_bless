package school.faang.number.pi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }

    public static Point generatePoint() {
        double x = ThreadLocalRandom.current().nextDouble();
        double y = ThreadLocalRandom.current().nextDouble();
        return new Point(x, y);
    }
}
