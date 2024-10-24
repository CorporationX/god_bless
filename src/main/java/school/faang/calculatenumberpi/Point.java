package school.faang.calculatenumberpi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Point {
    private final double x;
    private final double y;

    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }
}

