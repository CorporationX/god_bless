package school.faang.task_49881;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Point {
    private float coordinateX;
    private float coordinateY;
    @Getter
    private static List<Point> insidePoints = new ArrayList<>();

    public boolean isInsideCircle() {
        return Math.pow(coordinateX, 2) + Math.pow(coordinateY, 2) <= 1;
    }
}
