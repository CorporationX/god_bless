package pave.way.with.your.finger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {
    private double x;
    private double y;

    public double distanceTo(Location location) {
        return Math.sqrt(
            Math.pow(this.x - location.getX(), 2) + Math.pow(this.y - location.getY(), 2)
        );
    }
}
