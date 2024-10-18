package ru.kraiush.BJS2_36315;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Location cityLocation = city.getLocation();
        double distanceToCity = Math.sqrt(Math.pow(cityLocation.getX(), 2) + Math.pow(cityLocation.getY(), 2));
        double distanceToClosestMonster = monsters.stream()
                .mapToDouble(monster -> Math.sqrt(Math.pow(monster.getLocation().getX() - cityLocation.getX(), 2) +
                                                  Math.pow(monster.getLocation().getY() - cityLocation.getY(), 2)))
                .min().orElse(0.0);
        double totalDistance = distanceToCity + distanceToClosestMonster;
        System.out.println("The distance to the city and to the closest monster around the city is " + totalDistance);
    }
}
