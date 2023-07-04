package Sprint_4_1_Task13;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public boolean circleInequality() {
        return x * x + y * y <= 1;
    }
}
