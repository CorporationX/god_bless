package school.faang.task3111.creature;

import lombok.AllArgsConstructor;
import school.faang.task3111.city.City;
import school.faang.task3111.city.Location;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    City city;
    List<Monster> monsters;

    @Override
    public void run() {
        Double distanceToCity = calculateDistance(city.getLocation(), new Location(0, 0));
        Double distanceToNearestMonster = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            Double distanceToMonster = calculateDistance(city.getLocation(), monster.getLocation());
            if (distanceToMonster < distanceToNearestMonster) {
                distanceToNearestMonster = distanceToMonster;
            }
        }

        System.out.println("Расстояние до ближайшего монстра у города " + city.getName() + " = " + (distanceToCity + distanceToNearestMonster));
    }

    public double calculateDistance(Location firstLocation, Location secondLocation) {
        double x = Math.abs(Math.abs(firstLocation.getX()) - Math.abs(secondLocation.getX()));
        double y = Math.abs(Math.abs(firstLocation.getY()) - Math.abs(secondLocation.getY()));
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
