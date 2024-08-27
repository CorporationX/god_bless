package faang.school.godbless.BJS2_23905;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public int getDistanceTo(Location location) {
        return (Math.abs(location.x - x)) + (Math.abs(location.y - y));
    }
}
