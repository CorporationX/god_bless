package faang.school.godbless.paveTheWayWithYourFinger;

import lombok.Data;
import java.util.Random;

@Data
public class Monster {
    private String name;
    private String locationName;
    private Location location;

    public Monster(String name, String locationName) {
        this.name = name;
        this.locationName = locationName;
        location = new Location(new Random().nextInt(181),(new Random().nextInt(181)));
    }
}
