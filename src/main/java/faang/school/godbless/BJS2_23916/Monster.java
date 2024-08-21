package faang.school.godbless.BJS2_23916;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Monster {
    private String name;
    private String villageLocation;

    public Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "Skellige" -> {
                return new Location(10, 12);
            }
            default -> {
                return new Location(0,0);
            }
        }
    }
}
