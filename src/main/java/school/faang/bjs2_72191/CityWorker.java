package school.faang.bjs2_72191;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        double distanceToCity = Math.sqrt(
                Math.pow(city.getLocation().getLocX(), 2) + Math.pow(city.getLocation().getLocY(), 2));

        Map<Double, Monster> distanceToMonsterMap = monsters.stream()
                .collect(Collectors.toMap(monster -> getDistance(monster.getLocation()),
                        monster -> monster,
                        (m1, m2) -> m1));

        double minDistanceToMonster = distanceToMonsterMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()).limit(1).map(Map.Entry::getKey).toList().get(0);

        System.out.printf("Distance to city -> %f | distance from city to monster -> %f\n",
                distanceToCity,
                minDistanceToMonster);
        System.out.printf("Distance from Herald to monster -> %f\n", distanceToCity + minDistanceToMonster);
    }

    private double getDistance(Location location) {
        return Math.sqrt(Math.pow(location.getLocX() - city.getLocation().getLocX(), 2)
                + Math.pow(location.getLocY() - city.getLocation().getLocY(), 2));
    }
}
