package faang.school.godbless.BJS2_23910;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Monster {
    private String name;
    private Location villageLocation;

    public Monster(String name, String villageLocation) {
        this.name = name;
        this.villageLocation = getCoordinates(villageLocation);
    }

    private Location getCoordinates(String location) {
        return switch (location) {
            case "Velen" -> new Location(0, 90);
            case "Toussaint" -> new Location(50, 20);
            case "White Orchard" -> new Location(120, 70);
            case "Skellige" -> new Location(-50, 160);
            default -> new Location(0, 0);
        };
    }
}
