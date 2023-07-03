package faang.school.godbless.multithreading.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {
    private int x;
    private int y;

    public int calculateDistance(Location location) {
        int x2 = location.getX();
        int y2 = location.getY();
        return (int) Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
    }
}
