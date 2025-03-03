package school.faang.trackingsystem;

public class BaseLocation {
    private static final Location BORDER_BASE_COORDINATE_NORTH = new Location(100, 100);
    private static final Location BORDER_BASE_COORDINATE_SOUTH = new Location(0, 0);

    public static Location getBorderBaseCoordinateNorth() {
        return BORDER_BASE_COORDINATE_NORTH;
    }

    public static Location getBorderBaseCoordinateSouth() {
        return BORDER_BASE_COORDINATE_SOUTH;
    }
}
