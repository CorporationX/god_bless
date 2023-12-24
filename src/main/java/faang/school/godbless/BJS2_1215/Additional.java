package faang.school.godbless.BJS2_1215;

public class Additional {
    public static double calculateDistance(Location location1, Location location2) {
        double x1 = location1.getX();
        double y1 = location1.getY();
        double x2 = location2.getX();
        double y2 = location2.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}