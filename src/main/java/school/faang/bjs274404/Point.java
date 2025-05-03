package school.faang.bjs274404;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Point {
    private final double coordinateX;
    private final double coordinateY;
    
    public boolean isInsideCircle() {
        return coordinateX * coordinateX + coordinateY * coordinateY <= 1;
    }
}
