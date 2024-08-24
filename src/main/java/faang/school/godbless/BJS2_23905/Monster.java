package faang.school.godbless.BJS2_23905;

import lombok.Getter;

@Getter
public class Monster {
    private String name;
    private Location location;

    public Monster(String name, String location) {
        this.name = name;
        this.location = getLocationCoordinates(location);
    }

    public Location getLocationCoordinates(String location) {
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
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
