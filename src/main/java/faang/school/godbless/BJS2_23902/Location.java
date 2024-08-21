package faang.school.godbless.BJS2_23902;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Location {
    private final int x;
    private final int y;

    public double calculateDistance(Location location) {
        return Math.sqrt(Math.pow(location.getX() - x, 2) + Math.pow(location.getY() - y, 2));
    }

    public static Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(100, 10);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
