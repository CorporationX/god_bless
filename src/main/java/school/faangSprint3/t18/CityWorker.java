package school.faangSprint3.t18;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    private double calculateDistance(Location loc1, Location loc2) {
        int deltaX = loc1.getX() - loc2.getX();
        int deltaY = loc1.getY() - loc2.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public void run() {
        double distanceToCity = calculateDistance(new Location(0, 0), city.getLocation());
                Monster nearestMonster = null;
        double minDistanceToMonster = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double distanceToMonster = calculateDistance(city.getLocation(), monster.getLocation());
            if (distanceToMonster < minDistanceToMonster) {
                minDistanceToMonster = distanceToMonster;
                nearestMonster = monster;
            }
        }

        if (nearestMonster != null) {
            double totalDistance = distanceToCity + minDistanceToMonster;
            System.out.println(Thread.currentThread().getName() +
                    " | Город: " + city.getName() +
                    " | Монстр: " + nearestMonster.getName() +
                    " | До города: " + String.format("%.2f", distanceToCity) +
                    " | До монстра: " + String.format("%.2f", minDistanceToMonster) +
                    " | Общая дистанция: " + String.format("%.2f", totalDistance));
        }
    }
}