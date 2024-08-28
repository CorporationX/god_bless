package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Point {
    private double x;
    private double y;

    public static Point generatePoint() {
        RandomGenerator randomGenerator = new RandomGenerator();
        return new Point(randomGenerator.randomNum(), randomGenerator.randomNum());
    }
}
