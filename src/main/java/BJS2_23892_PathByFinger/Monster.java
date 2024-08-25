package BJS2_23892_PathByFinger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monster {
    private String monsterName;
    private Location villageLocation;
    private Location cityLocation;

    public Monster(String monsterName, String villageLocation) {
        this.monsterName = monsterName;
        this.villageLocation = getCoordinates(villageLocation);
    }

    public Location getCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(30, 60);
            }
            case "Toussaint" -> {
                return new Location(0, 50);
            }
            case "White Orchard" -> {
                return new Location(-15, 20);
            }
            case "Skellige" -> {
                return new Location(120, 45.3);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
