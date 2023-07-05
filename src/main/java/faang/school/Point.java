package faang.school;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public static Point getRandomPoint() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new Point(random.nextDouble(), random.nextDouble());
    }

    public boolean isInside() {
        return Math.pow(x, 2) + Math.pow(y, 2) < 1;
    }
}
