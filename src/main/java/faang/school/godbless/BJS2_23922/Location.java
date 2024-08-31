package faang.school.godbless.BJS2_23922;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {

    private final int coordinateX;
    private final int coordinateY;

    public double distanceTo(Location other) {
        return Math.sqrt(Math.pow(other.getCoordinateX() - this.coordinateX, 2) + Math.pow(other.getCoordinateY() - this.coordinateY, 2));
    }
}
