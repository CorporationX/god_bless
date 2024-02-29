package faang.school.godbless.pi;

import java.util.List;

public class PiCalculation {
    public static final double RADIUS = 1;
    public static final int NUMBER_OF_POINTS = 10_000_000;

    public static double calculatePi() {
        List<Point> uniquePoints = Point.generateRandomPoints(NUMBER_OF_POINTS);
        long inside = uniquePoints.stream()
                .filter(PiCalculation::validatePoint)
                .count();
        return (double) (4 * inside) / NUMBER_OF_POINTS;
    }

    public static boolean validatePoint(Point point) {
        double c = Math.sqrt(Math.pow(point.getA(), 2) + Math.pow(point.getB(), 2));
        return c <= RADIUS;
    }

    public static void main(String[] args) {
        System.out.println("PI equals " + calculatePi());
    }
}
