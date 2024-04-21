package TheWitcher;

import lombok.Getter;

@Getter
public class Monster {
    private String name;
    private Location villageLocation;

    public Monster (String name, String villageLocation) {
        this.name = name;
        this.villageLocation = getLocation(villageLocation);
    }

    public Location getLocation(String location) {
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
                return new Location(80, 20);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
