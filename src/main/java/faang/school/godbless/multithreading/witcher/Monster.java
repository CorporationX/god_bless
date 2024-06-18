package faang.school.godbless.multithreading.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;


@AllArgsConstructor
@Getter
public class Monster {

    private String name;
    private String location;

    public static Location getMonsterLocation(@NonNull Monster monster) {
        Location location;
        switch (monster.getLocation()) {
            case "Skellige" -> location = new Location(180, 40);
            case "Velen" -> location = new Location(140, 90);
            case "Toussaint" -> location = new Location(70, 60);
            case "White Orchard" -> location = new Location(30, 90);
            default -> location = new Location(0, 0);
        }
        return location;
    }
}
