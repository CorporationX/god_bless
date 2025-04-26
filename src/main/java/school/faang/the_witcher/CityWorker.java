package school.faang.the_witcher;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    List<Monster> monsters;

    private double calcDistance(Location location1, Location location2) {
        int deltaX = location1.getCoordinateX() - location2.getCoordinateX();
        int deltaY = location1.getCoordinateY() - location2.getCoordinateY();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }


    @Override
    public void run() {
        double distanceFromCastleToCity = calcDistance(new Location(0, 0), city.getLocation());

        double minDistance = Double.MAX_VALUE;
        Monster closestMonster = null;
        for (Monster monster : monsters) {
            double distanceToMonster = calcDistance(city.getLocation(), monster.getLocation());
            if (distanceToMonster < minDistance) {
                minDistance = distanceToMonster;
                closestMonster = monster;
            }
        }
        if (closestMonster != null) {
            double totalDistance = distanceFromCastleToCity + minDistance;
            log.info("Distance from Castle to city is {} and distance to closets monster from a city is {}",
                    distanceFromCastleToCity, totalDistance);
        }
    }
}
