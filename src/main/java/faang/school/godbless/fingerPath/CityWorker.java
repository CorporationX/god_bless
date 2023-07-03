package faang.school.godbless.fingerPath;

import java.util.List;

public class CityWorker implements Runnable{
    private final City city;
    private final List<Monster> monsters;
    private final Location defaultLocation;

    public CityWorker(City city, List<Monster> monsters, Location defaultLocation) {
        this.city = city;
        this.monsters = monsters;
        this.defaultLocation = defaultLocation;
    }

    public Monster findNearestMonster() {
        Monster nearestMonster = null;
        int minDistance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            Location monsterLocation = getLocationCoordinates(monster.getLocation());
            Location cityLocation = city.getLocation();
            int distance = Math.abs(cityLocation.getX() - monsterLocation.getX())
                    + Math.abs(cityLocation.getY() - monsterLocation.getY());

            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }

        return nearestMonster;
    }

    public long getKillTime() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 500;
    }

    public long getJourneyDistance() {
        int journeyDistance = 0;
        Location cityLocation = city.getLocation();
        int defaultDistance = Math.abs(cityLocation.getX() - defaultLocation.getX())
                + Math.abs(cityLocation.getY() - defaultLocation.getY());

        for (int distance : city.getDistances()) {
            journeyDistance += distance;
        }

        return journeyDistance - defaultDistance;
    }

    private Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen":
                return new Location(10, 20);
            case "Toussaint":
                return new Location(40, 50);
            case "White Orchard":
                return new Location(100, 10);
            case "Skellige":
                return new Location(80, 120);
            default:
                return new Location(0, 0);
        }
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        System.out.println("City: " + city.getName() + ", nearest monster: " + nearestMonster.getName());

        long killTime = getKillTime();
        System.out.println("City: " + city.getName() + ", kill time: " + killTime);

        long journeyDistance = getJourneyDistance();
        System.out.println("City: " + city.getName() + ", journey distance: " + journeyDistance);
    }

}
