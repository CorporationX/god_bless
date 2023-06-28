package faang.school.godbless.kxnvg.witcher;

import lombok.Getter;

import java.util.Random;

@Getter
public class Monster {

    private String name;
    private int power;
    private String location;
    private Location locationCoordinates;

    public Monster(String name, String location) {
        this.name = name;
        this.location = location;
        power = new Random().nextInt(10);
        locationCoordinates = determinationOfCoordinates(location);
    }

    private Location determinationOfCoordinates(String location) {
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
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
