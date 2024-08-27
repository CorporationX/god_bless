package faang.school.godbless.fourthsprint.pi;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point {
    private final double x;
    private final double y;

    public boolean isInsideCircle() {
        return (x * x + y * y) <= 1.0;
    }
}
