package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Monster {

    private static final Map<String, Location> locationCoordinates = initializeLocationCoordinates();

    private String name;
    private String location;

    public static Location getCoordinatesBy(String location) {
        return locationCoordinates.getOrDefault(location, new Location(0, 0));
    }

    private static Map<String, Location> initializeLocationCoordinates() {
        return Map.of(
            "Velen", new Location(0, 90),
            "Toussaint", new Location(40, 50),
            "White Orchard", new Location(100, -10),
            "Skellige", new Location(-80, 120)
        );
    }
}
