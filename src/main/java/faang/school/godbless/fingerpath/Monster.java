package faang.school.godbless.fingerpath;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Monster {
    private String name;
    private Location villageLocation;

    public Monster(String name, String villageLocation) {
        this.name = name;
        this.villageLocation = getCoordinates(villageLocation);
    }

    public Location getCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(0, 90);
            }
            case "Toussaint" -> {
                return new Location(50, 20);
            }
            case "White Orchard" -> {
                return new Location(120, 70);
            }
            case "Skellige" -> {
                return new Location(-50, 160);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
