package faang.school.godbless.BJS2_23886;

import lombok.Getter;
@Getter
public class Monster {
    private final String name;
    private final Location location;

    public Monster(String name, String area) {
        this.name = name;
        this.location = getLocation(area);
    }

    private Location getLocation(String area) {
        switch (area) {
            case "Velen" -> {
                return new Location(90, -20);
            }
            case "Toussaint" -> {
                return new Location(10, 40);
            }
            case "White Orchard" -> {
                return new Location(-30, -10);
            }
            case "Skellige" -> {
                return new Location(40, 130);
            }
            default -> throw new RuntimeException("Unknown area");
        }
    }
}
