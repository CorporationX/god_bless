package BJS2_12016;

import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable{
    private City city;
    private List<Monster> monsters;

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        int minDistance = Integer.MAX_VALUE;
        Monster nearestMonster = null;

        for (Monster monster : monsters) {
            int distance = monster.getLocation().distanceTo(city.getLocation());
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return new Random().nextInt(2000, 5000);
    }

    public long getJourneyDistance() {
        return city.getDistanceToCity();
    }

    @Override
    public void run() {

    }
}
