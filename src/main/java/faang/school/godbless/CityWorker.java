package faang.school.godbless;

import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = null;
        int minDistance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            Location monsterLocation = monster.getLocation();
            Location cityLocation = city.getLocation();
            int distance = calculateDistance(monsterLocation, cityLocation);

            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getJourneyDistance() {
        Location witcherLocation = new Location(180, 70);
        Location cityLocation = city.getLocation();

        return calculateDistance(witcherLocation, cityLocation);
    }

    public long getKillTime() {
        int minSeconds = 1;
        int maxSeconds = 10;
        Random random = new Random();
        int randomSeconds = random.nextInt(maxSeconds - minSeconds + 1) + minSeconds;
        long killTime = randomSeconds * 1000;
        return killTime;
    }

    private int calculateDistance(Location location1, Location location2) {
        int xDiff = Math.abs(location1.getX() - location2.getX());
        int yDiff = Math.abs(location1.getY() - location2.getY());
        return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);
        if (nearestMonster != null) {
            long journeyDistance = getJourneyDistance();
            long killTime = getKillTime();

            System.out.println("Witcher Geralt is traveling to " + city.getName());
            System.out.println("Journey distance: " + journeyDistance);
            System.out.println("Killing monster: " + nearestMonster.getName());
            System.out.println("Kill time: " + killTime);
        }
    }
}
