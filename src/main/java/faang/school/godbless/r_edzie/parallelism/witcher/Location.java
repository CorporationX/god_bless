package faang.school.godbless.r_edzie.parallelism.witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Location {
    private int x;
    private int y;

    public double distanceTo(Location otherLocation) {
        int xDiff = this.x - otherLocation.getX();
        int yDiff = this.y - otherLocation.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
