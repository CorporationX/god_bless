package school.faang.magicmap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.magicmap.domain.City;
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

    public static final int WORK_TIME = 100;
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        var cityX = city.location().x();
        var cityY = city.location().y();
        var distanceToCity = Math.sqrt(Math.pow(cityX, 2) + Math.pow(cityY, 2));
        try {
            Thread.sleep(WORK_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
            return;
        }
        var cityName = city.name();
        var distanceResults = monsters.stream()
                .map(monster -> {
                    var x = monster.location().x();
                    var y = monster.location().y();
                    var d = Math.sqrt(Math.pow(Math.abs(x - cityX), 2) + Math.pow(Math.abs(y - cityY), 2));
                    return Map.entry(monster.name(), d);
                })
                .toList();
        distanceResults.forEach(entry ->
                log.info("Расстояние от замка до города {} = {}; Расстояние от города {} до монстра {} = {}",
                        cityName, distanceToCity, cityName, entry.getKey(), entry.getValue()));
        var nearestMonster = distanceResults.stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> DistanceNotFoundException.fromCityToAnyMonster(cityName));
        log.info("Ближайший к городу {} монстр - {}", cityName, nearestMonster.getKey());
    }
}
