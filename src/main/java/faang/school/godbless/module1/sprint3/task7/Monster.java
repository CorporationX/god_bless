package faang.school.godbless.module1.sprint3.task7;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Monster {
    private String name;
    private String villageLocation;
    private Location cityLocation;

    public Monster(String name, String villageLocation) {
        this.name = name;
        this.villageLocation = villageLocation;
        this.cityLocation = getLocationCoordinates(villageLocation);
    }


    public static Location getLocationCoordinates(String villageLocation) {
        return switch (villageLocation) {
            case "Velen" -> new Location(10, 20);
            case "Toussaint" -> new Location(40, 50);
            case "White Orchard" -> new Location(100, 10);
            case "Skellige" -> new Location(80, 120);
            default -> new Location(0, 0);
        };
    }
}
