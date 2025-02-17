package school.faang.putfingeronpath;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Location {
    private final double x;
    private final double y;

    public double distanceTo(Location other) {
        return Math.hypot(this.getX() - other.getX(), this.getY() - other.getY());
    }
}
