package faang.school.godbless.dolbahlop.multithreading.parallelism;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public int getDistanceTo(Location location) {
        return (Math.abs(location.x - x) + (Math.abs(location.y) - y));
    }
}
