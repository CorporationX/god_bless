package faang.school.godbless.priscillasong2904;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Monster {
    private String name;
    private String cityName;
    private static final List<Monster> MONSTERS = createMonsters();

    public Monster(String name, String location) {
        this.name = name;
        this.cityName = location;
    }

    public Location getLocation() {
        return switch (this.getCityName()) {
            case "Velen" -> new Location(0, 60);
            case "Toussaint" -> new Location(60, 0);
            case "White Orchard" -> new Location(120, 50);
            case "Kaer Morhen" -> new Location(180, 70);
            default -> new Location(0, 0);
        };
    }

    private static List<Monster> createMonsters() {
        return new ArrayList<>(List.of(
                new Monster("Wilkolak", "Velen"),
                new Monster("Alghoul", "Toussaint"),
                new Monster("Borowik", "White Orchard"),
                new Monster("Gryf", "White Orchard"),
                new Monster("Alghoul", "Toussaint"),
                new Monster("Gryf", "Toussaint"),
                new Monster("Borowik", "Velen")
        ));
    }

    public static List<Monster> getMonsters() {
        return MONSTERS;
    }
}
