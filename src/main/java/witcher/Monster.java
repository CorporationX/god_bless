package witcher;

import java.util.Random;

public class Monster {
    private String name;
    private String location;
    private static Random random = new Random();

    public Location getCoordinates() {
        switch (location) {
            case "Velen" -> {
                return new Location(0, 90);
            }
            case "Toussaint" -> {
                return new Location(200, 75);
            }
            case "White Orchard" -> {
                return new Location(50, 50);
            }
            case "Skellige" -> {
                return new Location(-190, -20);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }

    public Monster(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double calculateDistanceToCity(City city) {
        Location monsterLocation = getCoordinates();
        double distanceX = Math.abs(monsterLocation.getX() - city.getLocation().getX());
        double distanceY = Math.abs(monsterLocation.getY() - city.getLocation().getY());
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    public long getKillTime() {
        return random.nextInt(1,1001);
    }
}
