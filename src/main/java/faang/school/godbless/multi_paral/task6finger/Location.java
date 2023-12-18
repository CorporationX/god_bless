package faang.school.godbless.multi_paral.task6finger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public double distanceTo(Location otherLocation) {
        int xDiff = this.x - otherLocation.getX();
        int yDiff = this.y - otherLocation.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff); // Пифагор
    }
}
