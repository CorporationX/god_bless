package faang.school.godbless.multithreading.finger_way;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {
    private int x;
    private int y;

    public int getDistance(Location other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }
}
