package school.faang.bjs248281.model;

public record Monster(String name, Location location) {
    public static Location getSpawn(Location spawn, double radius) {
        double angle = Math.random() * 2 * Math.PI;
        double distance = Math.sqrt(Math.random()) * radius;
        double x = spawn.x() + distance * Math.cos(angle);
        double y = spawn.y() + distance * Math.sin(angle);
        return new Location(x, y);
    }
}
