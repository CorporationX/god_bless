package school.faang.trackingsystem;

import java.util.Random;

public record Location(double latitude, double longitude) {
    private static final Random RANDOM = new Random();

    public Location() {
        this(101 + RANDOM.nextDouble(1000), 101 + RANDOM.nextDouble(1000));
    }

    public boolean isWithinBase() {
        return latitude() <= BaseLocation.getBorderBaseCoordinateNorth().latitude()
                && latitude() >= BaseLocation.getBorderBaseCoordinateSouth().latitude()
                && longitude() <= BaseLocation.getBorderBaseCoordinateNorth().longitude()
                && longitude() >= BaseLocation.getBorderBaseCoordinateSouth().longitude();
    }

    public boolean isOutsideBase() {
        return !isWithinBase();
    }
}
