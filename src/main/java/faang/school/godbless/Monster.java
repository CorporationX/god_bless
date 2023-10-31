package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monster {
    private String name;
    private Location villageLocation;

    public Monster(String name, String villageLocation) {
        this.name = name;
        this.villageLocation = getCoordinates(villageLocation);
    }

    public static Location getCoordinates(String location){
        switch (location){
            case "Velen" -> {
                return new Location(10, 80);
            }
            case "Toussaint" -> {
                return new Location(50, 40);
            }
            case "White Orchard" -> {
                return new Location(90, 120);
            }
            case "Skellige" -> {
                return new Location(30, 240);
            }
            default -> {
                return new Location(0,0);
            }
        }
    }
}
