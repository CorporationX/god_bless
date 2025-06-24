package school.faang.magicmap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.magicmap.domain.City;
import school.faang.magicmap.domain.Location;
import school.faang.magicmap.domain.Monster;
import school.faang.magicmap.exception.DistanceNotFoundException;

import java.util.List;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "CityWorker")
@RequiredArgsConstructor
public class CityWorker implements Runnable {

    private static final int WORK_TIME = 100;
    private static final Location START_LOCATION = new Location(0, 0);

    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        var distanceToCity = city.location().distanceTo(START_LOCATION);
        try {
            Thread.sleep(WORK_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
            return;
        }
        var cityName = city.name();
        var nearestMonster = monsters.stream()
                .map(monster -> {
                    var d = city.location().distanceTo(monster.location());
                    log.info("Расстояние от замка до города {} = {}; Расстояние от города {} до монстра {} = {}",
                            cityName, distanceToCity, cityName, monster.name(), d);
                    return Map.entry(monster.name(), d);
                }).min(Map.Entry.comparingByValue())
                .orElseThrow(() -> DistanceNotFoundException.fromCityToAnyMonster(cityName));
        log.info("Ближайший к городу {} монстр - {}", cityName, nearestMonster.getKey());
    }
}
