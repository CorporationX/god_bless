package school.faang.trackingsystem;

import java.util.Random;

import static school.faang.trackingsystem.BaseLocation.BORDER_BASE_COORDINATE_NORTH;
import static school.faang.trackingsystem.BaseLocation.BORDER_BASE_COORDINATE_SOUTH;

public record Location(double latitude, double longitude) {
    private static final Random RANDOM = new Random();

    public Location() {
        this(101 + RANDOM.nextDouble(1000), 101 + RANDOM.nextDouble(1000));
    }

    public boolean isWithinBase() {
        return latitude() <= BORDER_BASE_COORDINATE_NORTH.latitude()
                && latitude() >= BORDER_BASE_COORDINATE_SOUTH.latitude()
                && longitude() <= BORDER_BASE_COORDINATE_NORTH.longitude()
                && longitude() >= BORDER_BASE_COORDINATE_SOUTH.longitude();
    }

    public boolean isOutsideBase() {
        return !isWithinBase();
    }
}
