package faang.school;

import java.util.concurrent.ThreadLocalRandom;

public class Point {
    private double x;
    private double y;

    Point() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        this.x = random.nextDouble();
        this.y = random.nextDouble();
    }

    public boolean isInside() {
        return Math.pow(x, 2) + Math.pow(y, 2) < 1;
    }
}
