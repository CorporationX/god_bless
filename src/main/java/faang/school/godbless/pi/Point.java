package faang.school.godbless.pi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Point {
    private double x;
    private double y;

    public boolean isInside(double radius) {
        return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius, 2);
    }
}
