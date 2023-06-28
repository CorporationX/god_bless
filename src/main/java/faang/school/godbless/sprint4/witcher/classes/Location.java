package faang.school.godbless.sprint4.witcher.classes;

public record Location(int x, int y) {
    public static double getDistance(Location firstLocation, Location secondLocation) {
        return Math.sqrt(
                Math.pow(firstLocation.x - secondLocation.x, 2) + Math.pow(firstLocation.y - secondLocation.y, 2)
        );
    }
}
