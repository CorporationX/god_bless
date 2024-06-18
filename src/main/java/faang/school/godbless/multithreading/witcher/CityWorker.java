package faang.school.godbless.multithreading.witcher;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private static final int KILL_TIME = 5000;

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {

        Monster monster = findNearestMonster(city, monsters);
        long distanceBetweenCityMonster = getDistanceBetween(city.getLocation(), Monster.getMonsterLocation(monster));

        System.out.println("Witcher go to the city - " + city.getName() + ". Distance is - " + getJourneyDistance());
        System.out.println("Whitcher go to the nearst monster - " + monster.getName() + ". Distance is - " + distanceBetweenCityMonster);
        threadSleep(distanceBetweenCityMonster);

        System.out.println("Witcher kill the monster - " + monster.getName() + ". Time is - " + getKillTime());
        System.out.println("Witcher go back to the city - " + city.getName() + ". Distance is - " + getJourneyDistance());
    }

    public Monster findNearestMonster(@NonNull City city, List<Monster> monsters) {

        double nearestDistance = Double.MAX_VALUE;
        Monster nearestMonster = null;

        for (Monster monster : monsters) {
            double distance = getDistanceBetween(city.getLocation(), Monster.getMonsterLocation(monster));
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestMonster = monster;
            }
        }
        if (nearestMonster == null) {
            throw new NoSuchElementException("No monster found in the list");
        }
        return nearestMonster;
    }

    public long getKillTime() {
        int killTime = new Random().nextInt(KILL_TIME);
        threadSleep(killTime);
        return killTime;
    }

    public long getJourneyDistance() {
        int distanceToCity = city.getDistanceToWitcher();
        threadSleep(distanceToCity);
        return distanceToCity;
    }

    private long getDistanceBetween(@NonNull Location firstLocation, @NonNull Location secondLocation) {
        int firstLocationX = firstLocation.getX();
        int firstLocationY = firstLocation.getY();
        int secondLocationX = secondLocation.getX();
        int secondLocationY = secondLocation.getY();
        double distance = Math.sqrt(Math.pow(firstLocationX - secondLocationX, 2) + Math.pow(firstLocationY - secondLocationY, 2));
        return Math.round(distance);
    }

    private void threadSleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
