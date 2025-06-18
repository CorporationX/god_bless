package school.faang.bjs2_81585;

import lombok.Getter;
import lombok.ToString;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@ToString
public class Location {
    private static final int MAX_MAP_LENGTH = 20;
    private int coordX;
    private int coordY;

    public Location() {
        this.coordX = ThreadLocalRandom.current().nextInt(MAX_MAP_LENGTH);;
        this.coordY = ThreadLocalRandom.current().nextInt(MAX_MAP_LENGTH);
    }

    public Location(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }
}
