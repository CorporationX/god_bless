package school.faang.pi;

import lombok.Data;

@Data
public class Point {
    public final double xx;
    public final double yy;

    public boolean isInsideCircle() {
        return xx * xx + yy * yy <= 1;
    }
}
