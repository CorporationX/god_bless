package faang.school.godbless.pathFinger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
    private final int x;
    private final int y;

    public long getDistanceBetweenTwoLocations(Location location) {
        return (long) Math.sqrt((location.getX() - x) ^ 2 + (location.getY() - y) ^ 2);
    }
}
