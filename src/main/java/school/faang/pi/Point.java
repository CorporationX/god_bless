package school.faang.pi;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }
}
