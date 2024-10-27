package school.faang.m1s4.bjs2_38347_pi;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@EqualsAndHashCode
public class Point {
    private final double x;
    private final double y;

    public Point() {
        x = ThreadLocalRandom.current().nextDouble();
        y = ThreadLocalRandom.current().nextDouble();
    }

    public double calculateDistanceFromCenter() {
        return Math.sqrt((x * x + y * y));
    }

    public double calculateDistanceFromOtherPoint(Point otherPoint) {
        double zSquared = Math.pow(x - otherPoint.getX(), 2) + Math.pow(y - otherPoint.getY(), 2);
        return Math.sqrt(zSquared);
    }
}
