package school.faang.witcher.magic.map;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public static Location set() {
        Random random = new Random();
        int x = random.nextInt(-1000, 1000);
        int y = random.nextInt(-1000, 1000);

        return new Location(x, y);
    }

    public static double distance(Location departure, Location destination) {
        int x1 = departure.getX();
        int y1 = departure.getY();
        int x2 = destination.getX();
        int y2 = destination.getY();

        return Math.hypot((x1 - x2), (y1 - y2));
    }
}
