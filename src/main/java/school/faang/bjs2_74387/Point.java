package school.faang.bjs2_74387;

import lombok.Data;

@Data
public class Point {

    private final double pointX;
    private final double pointY;

    public boolean isInsideCircle() {
        return pointX * pointX + pointY * pointY <= 1;
    }
}
