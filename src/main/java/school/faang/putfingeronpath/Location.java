package school.faang.putfingeronpath;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Location {
    private final double xCoordinate;
    private final double yCoordinate;

    public double distanceTo(Location other) {
        return Math.hypot(
                this.getXCoordinate() - other.getXCoordinate(),
                this.getYCoordinate() - other.getYCoordinate()
        );
    }
}
