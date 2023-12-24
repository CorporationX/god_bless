package faang.school.godbless.BJS2_1215;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Getter
public class Monster {
    private String name;
    private Location location;

    public Monster(String name, String location) {
        this.name = name;
        this.location = findLocation(location);
    }

    private Location findLocation (String locationName) {
        return switch (locationName) {
            case "Velen" -> new Location(40, 20);
            case "Toussaint" -> new Location(-35, -150);
            case "White Orchard" -> new Location(-120, 10);
            case "Skellige" -> new Location(30, 100);
            default -> throw new NoSuchElementException("There is no such location on our list: " + locationName);
        };
    }
}