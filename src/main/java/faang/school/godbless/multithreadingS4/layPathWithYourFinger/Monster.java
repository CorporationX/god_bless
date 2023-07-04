package faang.school.godbless.multithreadingS4.layPathWithYourFinger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Monster {
    private String name;
    private String nameLocation;
    private Location location;

    public Monster(String name, String nameLocation) {
        this.name = name;
        this.nameLocation = nameLocation;
        location = setLocation();
    }

    private Location setLocation() {
        switch (nameLocation) {
            case "Velen" -> {
                return new Location(0, 70);
            }
            case "Toussaint" -> {
                return new Location(70, 30);
            }
            case "White Orchard" -> {
                return new Location(20, 90);
            }
            case "Skellige" -> {
                return new Location(90, 90);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
