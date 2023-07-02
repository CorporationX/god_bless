package faang.school.godbless.kxnvg.witcher;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);
        try {
            Thread.sleep(getKillTime(nearestMonster) + getJourneyDistance(nearestMonster));
        } catch (InterruptedException e) {
            throw new RuntimeException("Метод Thread.sleep был прерван");
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        if (monsters.isEmpty()) {
            throw new IllegalArgumentException("Список монстров пуст");
        }

        Location cityLocation = city.getLocation();
        Monster nearestMonster = monsters.get(0);
        double minDistance = Double.MAX_VALUE;
        Location monsterLocation;

        for (Monster monster : monsters) {
            monsterLocation = monster.getLocationCoordinates();
            double distance = distanceCalculation(cityLocation, monsterLocation);
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime(Monster monster) {
        return new Random().nextLong(1000) * monster.getPower();
    }

    public long getJourneyDistance(Monster monster) {
        double distanceFromCityToMonster = distanceCalculation(city.getLocation(), monster.getLocationCoordinates());
        return (long) (distanceFromCityToMonster + city.getDistance());
    }

    private double distanceCalculation(Location firstLocation, Location secondLocation) {
        int x1 = firstLocation.getX();
        int y1 = firstLocation.getY();
        int x2 = secondLocation.getX();
        int y2 = secondLocation.getY();

        return Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }
}
