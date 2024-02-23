package finger_way;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@AllArgsConstructor
@Setter
public class Monster {
    String name;
    private Location villagelocation;

    public Monster(String name, String villagelocation) {
        this.name = name;
        this.villagelocation = getCoordinates(villagelocation);
    }

    private static final Map<String, Location> LOCATIONS = Map.of(
            "Velen", new Location(0, 90),
            "Toussaint", new Location(50, 20),
            "White Orchard", new Location(120, 70),
            "Skellige", new Location(50, 160)
    );

    public static Location getCoordinates(String location) {
        return LOCATIONS.getOrDefault(location, new Location(0, 0));
    }
}
