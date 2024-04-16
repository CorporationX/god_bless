package faang.school.godbless.multithreading.task_7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Monster {
    private final String name;
    private final String habitat;

    public Location getCoordinatesByHabitat(String habitat) {
        switch (habitat) {
            case "Velen" -> {
                return new Location(15, 66);
            }
            case "Toussaint" -> {
                return new Location(96, 11);
            }
            case "White Orchard" -> {
                return new Location(50, 121);
            }
            case "Skellige" -> {
                return new Location(88, -44);
            }
            default -> {
                return new Location(-122, -114);
            }
        }
    }
}