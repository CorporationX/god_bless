package school.faang;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Point {
    private final double posX;
    private final double posY;

    public boolean isInsideCircle() {
        return posX * posX + posY * posY <= 1.0;
    }
}
