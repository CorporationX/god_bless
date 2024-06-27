package faang.school.godbless.parallelism.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class Monster {
    private String monsterName;
    private String regionLocation;
    private Location location;
    private int health;

    public Monster(String monsterName, String regionLocation) {
        if (monsterName.isBlank() || regionLocation.isBlank() || monsterName == null || regionLocation == null) {
            throw new IllegalArgumentException("Monster name and region location cannot be null or empty");
        }
        this.monsterName = monsterName;
        this.regionLocation = regionLocation;
        this.location = getLocationCoordinates(regionLocation);
        this.health = getMonsterHealth(monsterName);
    }

    private Location getLocationCoordinates(String regionLocation) {
        switch (regionLocation) {
            case "Velen" -> {
                return new Location(25, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(100, 30);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);

            }
        }
    }

    private int getMonsterHealth(String monsterName) {
        switch (monsterName) {
            case "Griffin" -> {
                return 150;
            }
            case "Basilisk" -> {
                return 80;
            }
            case "Cockatrice" -> {
                return 180;
            }
            case "Chort" -> {
                return 300;
            }
            default -> {
                return 100;
            }
        }
    }


}
