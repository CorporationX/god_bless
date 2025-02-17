package school.faang.putfingeronpath;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Location {
    private final double coordinateX;
    private final double coordinateY;

    public double distanceTo(Location other) {
        return Math.hypot(
                this.getCoordinateX() - other.getCoordinateX(),
                this.getCoordinateY() - other.getCoordinateY()
        );
    }
}
