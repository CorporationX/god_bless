package faang.school.godbless.Task_Calculating_Pi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Point {

    private double x;
    private double y;

    public Point() {
        this.x = Math.random();
        this.y = Math.random();
    }

    public Point(double x, double y) {
        if (x < 0 || y < 0 || x > 1 || y > 1) throw new IllegalArgumentException("invalid value(s)");
        else {
            this.x = x;
            this.y = y;
        }
    }

    public boolean checkIfInside() {
        return this.x * this.x + this.y * this.y <= 1;
    }

}
