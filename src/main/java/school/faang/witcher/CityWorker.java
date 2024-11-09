package school.faang.witcher;

import java.util.List;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

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
            System.out.println("Город: " + city.getName() + " | Монстр: " + nearestMonster.getName() +
                    " | Общая дистанция: " + totalDistance);
        }
    }
}

