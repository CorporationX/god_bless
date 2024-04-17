package faang.school.godbless.bjs2_5461;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Nearest monster to city " + city.getName() + " is " + findNearestMonster().getName());
        System.out.println("Time to kill: " + getKillTime());
        System.out.println("Distance to the " + city.getName() + " equals " + getJourneyDistance());
    }

    public Monster findNearestMonster() {

        Monster nearestMonster = null;
        int distance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            int newDistance = getNewDistance(city, Location.getLocationCoordinates(monster.getLocation()));

            if (newDistance < distance) {
                distance = newDistance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    private static int getNewDistance(City city, Location monsterLocation) {
        int diffX = Math.abs(city.getLocation().getX() - monsterLocation.getX());
        int diffY = Math.abs(city.getLocation().getY() - monsterLocation.getY());

        return diffX + diffY;
    }

    public long getKillTime() {
        return new Random().nextInt(10 - 1) + 1;
    }

    public long getJourneyDistance() {
        return city.getDistanceToWitcher();
    }
}
