package school.faang.bjs2_72219.model;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_72219.LocationUtil;

import java.util.Comparator;
import java.util.List;

@Slf4j
public record CityWorker(City city, List<Monster> monsters) implements Runnable {
    @Override
    public void run() {
        double distance = LocationUtil.getDistance(LocationUtil.castleLocation, city.location());
        Monster nearestMonster = monsters.stream()
                .min(Comparator.comparingDouble(monster -> LocationUtil.getDistance(city.location(),
                        monster.location())))
                .orElseThrow(() -> new IllegalArgumentException("Monsters list is empty"));
        log.info("The route is: {} km. to city {} and then {} km. to nearest monster {}", distance, city.name(),
                LocationUtil.getDistance(city.location(), nearestMonster.location()), nearestMonster.name());
    }
}