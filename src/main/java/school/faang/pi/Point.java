package school.faang.pi;

import lombok.Data;

@Data
public class Point {
    public final double x;
    public final double y;

    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }
}
