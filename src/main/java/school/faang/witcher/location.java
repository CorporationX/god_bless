package school.faang.witcher;
public class location {
    private int xCoordinate;
    private int yCoordinate;

    public location(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    public int X() {
        return xCoordinate;
    }

    public int Y() {
        return yCoordinate;
    }
}
