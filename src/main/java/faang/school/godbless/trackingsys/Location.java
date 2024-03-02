package faang.school.godbless.trackingsys;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public final class Location {

    private static final Random RANDOM = new Random();
    private final int latitude;
    private final int longitude;

    public static Location getRandomLocation() {
        return new Location(RANDOM.nextInt((90 + 90)) - 90, RANDOM.nextInt(180 + 180) - 180);
    }
}