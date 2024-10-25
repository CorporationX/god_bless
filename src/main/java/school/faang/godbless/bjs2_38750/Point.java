package school.faang.godbless.bjs2_38750;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Point {
    private double x;
    private double y;

    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }
}
