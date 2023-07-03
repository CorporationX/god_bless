package faang.school.godbless.Sprint4.task10;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monster {
    private String name;
    private Location villageLocation;
    private Location cityLocation;

    public Monster(String name, String villageLocation) {
        this.name = name;
        this.villageLocation = getCoordinates(villageLocation);
    }

    public Location getCoordinates(String location) {
        switch (location) {
            case "Velen":
                return new Location(0, 90);
            case "Toussaint":
                return new Location(50, 20);
            case "White Orchard":
                return new Location(120, 50);
            case "Skellige":
                return new Location(180, 70);
            default:
                return new Location(0, 0);
        }
    }
}
