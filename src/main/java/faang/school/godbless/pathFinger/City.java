package faang.school.godbless.pathFinger;

import lombok.Getter;

import java.util.Map;

@Getter
public class City {
    private final String name;
    private final Location location;
    private final Map<Monster, Long> monsterKillTime;

    public City(String name, Location location, Map<Monster, Long> monsterKillTime) {
        searchValidDataCity(name, location, monsterKillTime);
        this.name = name;
        this.location = location;
        this.monsterKillTime = monsterKillTime;
    }

    private void searchValidDataCity(String name, Location location, Map<Monster, Long> monsterKillTime) {
        if (name == null || name.isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException(
                    "The constructor of the City class should not receive an empty name");
        }
        if (location == null) {
            throw new IllegalArgumentException(
                    "The constructor of the City class should not receive an empty location");
        }
        if (monsterKillTime.isEmpty() || monsterKillTime == null) {
            throw new IllegalArgumentException(
                    "The constructor of the City class should not receive an empty or null Map");
        }
    }
}
