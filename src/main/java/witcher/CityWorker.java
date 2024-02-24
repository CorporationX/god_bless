package witcher;

import java.util.List;

public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        long killTime = getKillTime(nearestMonster);
        Location journeyDistance = getJourneyDistance();
        System.out.println("City: " + city.getName() + ", Nearest Monster: " + nearestMonster.getName() + ", Total Kill Time: " + killTime + ", Journey Distance: X=" + journeyDistance.getX() + ", Y=" + journeyDistance.getY());
    }

    public Monster findNearestMonster() {
        Monster nearestMonster = null;
        double minDistance = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            Location monsterLocation = monster.getCoordinates();
            double distance = calculateDistance(city.getLocation(), monsterLocation);
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }

        return nearestMonster;
    }

    private double calculateDistance(Location location1, Location location2) {
        double distanceX = Math.abs(location1.getX() - location2.getX());
        double distanceY = Math.abs(location1.getY() - location2.getY());
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    public long getKillTime(Monster monster) {
        return monster.getKillTime();
    }

    public Location getJourneyDistance() {
        Monster nearestMonster = findNearestMonster();
        Location cityLocation = city.getLocation();
        Location monsterLocation = nearestMonster.getCoordinates();

        double distanceX = Math.abs(cityLocation.getX() - monsterLocation.getX());
        double distanceY = Math.abs(cityLocation.getY() - monsterLocation.getY());

        return new Location(distanceX, distanceY);
    }
}

