package faang.school.godbless.multithreading.finger_way;

import lombok.Getter;

@Getter
public class Monster {
    private final String name;
    private Location villageLocation;
    private Location cityLocation;

    public Monster(String name, Location cityLocation) {
        this.name = name;
        this.cityLocation = cityLocation;
    }

    public Monster(String name, String villageLocation) {
        this.name = name;
        this.villageLocation = getCoordinates(villageLocation);
    }

    private Location getCoordinates(String villageLocation) {
        switch (villageLocation) {
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

    public String getName() {
        return name;
    }
}
