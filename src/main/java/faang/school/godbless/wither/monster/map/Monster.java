package faang.school.godbless.wither.monster.map;

import lombok.Getter;

import java.util.HashMap;
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

    private static final Map<String, Location> placeLocationMap = new HashMap<>();

    public static void addPlaceLocation(String place, Location location) {
        placeLocationMap.put(place, location);
    }

    public Location getLocation() {
        return Optional.ofNullable(placeLocationMap.get(place))
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no information about place: %s", place)));
    }
}
