package faang.school.godbless.fingerpath;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Monster {
    private String name;
    private String location;

    public Location getCoordinates() {
        switch (location) {
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
}
