package faang.school.godbless.pi;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public boolean isInsideCircle() {
        return x * x + y * y <= 1.0;
    }

    public static Point generate() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double x = random.nextDouble();
        double y = random.nextDouble();
        return new Point(x, y);
    }

}
