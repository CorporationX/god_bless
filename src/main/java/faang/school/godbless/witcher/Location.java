package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public double calculateDistance(Location otherLoc) {
        int xDiff = Math.abs(x - otherLoc.getX());
        int yDiff = Math.abs(y - otherLoc.getY());
        return xDiff + yDiff;
    }
}
