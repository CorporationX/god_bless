package faang.school.godbless.pave_the_way;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Monster {
    private String name;
    private String location;


    public Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(0, 50);
            }
            case "Toussaint" -> {
                return new Location(60, 50);
            }
            case "White Orchard" -> {
                return new Location(80, 80);
            }
            case "Skellige" -> {
                return new Location(120, 10);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }

}
