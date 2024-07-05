package faang.school.godbless.future.pi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private double x;
    private double y;

    public boolean isInside(double radius) {
        return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius, 2);
    }
}
