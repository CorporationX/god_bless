package faang.school.godbless.alexbulgakoff.multithreading.parallelism.pavethewaywithyourfinger;

import lombok.Getter;
import lombok.ToString;

import java.util.Random;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Monster {
    private String name;
    private String location;

    public Monster(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Location getMonsterCoordinate() {
        Random random = new Random();
        return new Location(random.nextInt(50), random.nextInt(100));
    }
}
