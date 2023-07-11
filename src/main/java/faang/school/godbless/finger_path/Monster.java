package faang.school.godbless.finger_path;

import lombok.Data;

import java.util.Random;

@Data
public class Monster {

    private String name;
    private String place;
    private Location location;
    private int health;

    private Random random = new Random();

    public Monster(String name, String place) {
        this.name = name;
        this.place = place;

        Location.locations.put(place, new Location(random.nextInt(), random.nextInt()));
        this.location = Location.locations.get(place);
        this.health = random.nextInt(1_000);
    }
}
