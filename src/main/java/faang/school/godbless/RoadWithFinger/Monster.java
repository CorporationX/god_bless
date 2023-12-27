package faang.school.godbless.RoadWithFinger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Monster {
    private String name;
    private String location;


    public Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(50, 10);
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
