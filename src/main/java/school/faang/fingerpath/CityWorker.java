package school.faang.fingerpath;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        double minDistanceToMonster = Double.MAX_VALUE;
        double distanceToCity = calculateDistance(new Location(0, 0), city.location());

        Monster nearestMonster = null;
        for (Monster monster : monsters) {
            double distanceToMonster = calculateDistance(city.location(), monster.location());
            if (distanceToMonster < minDistanceToMonster) {
                minDistanceToMonster = distanceToMonster;
                nearestMonster = monster;
            }
        }

        if (nearestMonster != null) {
            double totalDistance = distanceToCity + minDistanceToMonster;
            System.out.println("Город: " + city.name() + " | Монстр: " + nearestMonster.name() +
                    " | Общая дистанция: " + totalDistance);
        }
    }

    private double calculateDistance(Location loc1, Location loc2) {
        int deltaX = loc1.x() - loc2.x();
        int deltaY = loc1.y() - loc2.y();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
