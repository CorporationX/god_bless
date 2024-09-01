package faang.school.godbless.wither.monster.map;

import lombok.Getter;

import java.util.Map;
import java.util.Optional;

@Getter
public class Monster {
    private final String name;
    private final String place;

    public Monster(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public Location getLocation() {
        return Optional.ofNullable(getPlaceLocationMap().get(place))
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no information about place: %s", place)));
    }

    private Map<String, Location> getPlaceLocationMap() {
        return Map.of("Toussaint", new Location(10, 15),
                "White Orchard", new Location(140, 10),
                "Velen", new Location(200, 45),
                "Skellige", new Location(120, 85));
    }
}
