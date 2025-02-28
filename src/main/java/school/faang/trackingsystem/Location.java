package school.faang.trackingsystem;

import java.util.Random;

public record Location(double latitude, double longitude) {
    private static final Random RANDOM = new Random();

    public Location() {
        this(101 + RANDOM.nextDouble(1000), 101 + RANDOM.nextDouble(1000));
    }
}
