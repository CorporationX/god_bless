package faang.school.godbless.future.pi;

import lombok.Data;

import java.util.Random;

@Data
public class PointGenerator {

    public Point getPoint(double radius) {
        double x = new Random().nextDouble(0, radius + Double.MIN_VALUE);
        double y = new Random().nextDouble(0, radius + Double.MIN_VALUE);
        return new Point(x, y);
    }
}
