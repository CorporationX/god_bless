package school.faang.path;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;
    private int distanceFromWitcherToCity = 0;
    private int distanceFromCityToNearestMonster = Integer.MAX_VALUE;
    private Monster nearestMonster = null;

    @Override
    public void run() {
        distanceFromWitcherToCity = calculationDistanceFromCityToObject(new Location(0, 0));
        for (Monster monster : monsters) {
            int distanceFromCityToMonster = calculationDistanceFromCityToObject(monster.getLocation());
            if (distanceFromCityToMonster < distanceFromCityToNearestMonster) {
                distanceFromCityToNearestMonster = distanceFromCityToMonster;
                nearestMonster = monster;
            }
        }

        System.out.printf("Distance to city %s %d. From city to the nearest monster, whose name is %s, %d. \n" +
                        "Total distance from Witcher to the nearest monster is: %d\n" +
                "-------------------------------------------------------------------------\n",
                city.getName(), distanceFromWitcherToCity, nearestMonster.getName(), distanceFromCityToNearestMonster,
                distanceFromWitcherToCity + distanceFromCityToNearestMonster);
    }

    private int calculationDistanceFromCityToObject(Location location) {
        int distanceX = city.getLocation().getCoordinateX() - location.getCoordinateX();
        int distanceY = city.getLocation().getCoordinateY() - location.getCoordinateY();
        return (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }
}
