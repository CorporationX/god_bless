package school.faang.multithreading.parallelism.way.with.your.finger;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private final static Location WITCHER_HOUSE = new Location(0, 0);

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double distanceToCity = calculateDistance(WITCHER_HOUSE, city.getLocation());
        double distanceToMonster = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double newDistance = calculateDistance(city.getLocation(), monster.getLocation());
            if (newDistance < distanceToMonster) {
                distanceToMonster = newDistance;
            }
        }

        log.info("Расстояние от замка до города плюс расстояние от города до ближайшего монстра: {}", distanceToCity + distanceToMonster);
    }

    private double calculateDistance(Location from, Location to) {
        return Math.sqrt(Math.pow(to.getX() - from.getX(), 2)
                + Math.pow(to.getY() - from.getY(), 2));
    }
}
