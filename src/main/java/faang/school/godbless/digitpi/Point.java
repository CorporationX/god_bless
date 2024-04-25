package faang.school.godbless.digitpi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public double getSumPowCoordinates() {
        return (x * x) + (y * y);
    }
}
