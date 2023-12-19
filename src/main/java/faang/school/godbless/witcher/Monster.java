package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Monster {
    private String name;
    private String location;

    public Location getLocationMonster() {
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
                return new Location(250, 70);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }

}

