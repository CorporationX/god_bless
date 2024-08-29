package faang.school.godbless.piCalculator;

import lombok.Data;

@Data
public class Point {
    double x;
    double y;
    boolean isInside;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
