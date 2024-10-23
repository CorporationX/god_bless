package school.faang.multithreading.theWitcher;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Location castle = new Location(0, 0);
        double distanceToCity = calculateDistance(castle, city.getLocation());
        double minDistanceFromCityToMonster = Double.MAX_VALUE;
        Monster nearestMonster = null;

        for (Monster monster : monsters) {
            double distanceFromCityToMonster = calculateDistance(city.getLocation(), monster.getLocation());
            if (distanceFromCityToMonster < minDistanceFromCityToMonster) {
                minDistanceFromCityToMonster = distanceFromCityToMonster;
                nearestMonster = monster;
            }
        }

        if (nearestMonster != null) {
            double totalDistance = distanceToCity + minDistanceFromCityToMonster;
            System.out.println("Монстр: " + nearestMonster.getName() + " Город: " + city.getName() + ". Расстояние до монстра: " + totalDistance);
        }
    }

    private double calculateDistance(Location loc1, Location loc2) {
        int deltaX = loc2.getX() - loc1.getX();
        int deltaY = loc2.getY() - loc1.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

}
