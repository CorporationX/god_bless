package faang.school.godbless.BJS2_23884;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Monster {
    private String name;
    private String location;

    public Location getCoordinates() {
        switch (location) {
            case "Velen" -> {
                return new Location(55, 0);
            }
            case "Toussaint" -> {
                return new Location(20, 10);
            }
            case "White Orchard" -> {
                return new Location(100, 90);
            }
            case "Skellige" -> {
                return new Location(230, 180);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
