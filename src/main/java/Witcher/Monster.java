package Witcher;

import lombok.Getter;

@Getter
public class Monster {
    private String name;
    private String location;

    public Monster() {
    }

    public Monster(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Location getLocationCoordinates() {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(20, 30);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
