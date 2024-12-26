package school.faang.bjs248281.model;

public record Location(double x, double y) {
    public static double getDistance(Location l1, Location l2) {
        return Math.abs(Math.sqrt(Math.pow((l2.x() - l1.x()), 2) + Math.pow((l2.y() - l1.y()), 2)));
    }
}
