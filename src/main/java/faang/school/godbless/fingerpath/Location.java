package faang.school.godbless.fingerpath;

public class Location {
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int calculateDistance(Location location1, Location location2) {
        double deltaX = location1.getX() - location2.getX();
        double deltaY = location1.getY() - location2.getY();
        return (int) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
