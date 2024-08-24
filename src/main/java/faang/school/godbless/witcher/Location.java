package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public static double distance(Location location1, Location location2) {
        return Math.sqrt(Math.pow((location2.getX() - location1.getX()), 2) + Math.pow((location2.getY() - location1.getY()), 2));
    }
}
