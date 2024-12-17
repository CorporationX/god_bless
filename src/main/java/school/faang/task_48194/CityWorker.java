package school.faang.task_48194;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        if (monsters.isEmpty()) {
            throw new IllegalStateException("Monster cannot be empty");
        }

        double distanceFromWitcherToCity = Witcher.LOCATION.findDistance(getCity().getLocation());

        double nearestDistanceFromCityToMonster = -1;

        for (Monster monster : getMonsters()) {
            double distanceFromCityToMonster = getCity().getLocation().findDistance(monster.getLocation());
            if (nearestDistanceFromCityToMonster < 0
                    || distanceFromCityToMonster < nearestDistanceFromCityToMonster) {
                nearestDistanceFromCityToMonster = distanceFromCityToMonster;
            }
        }

        log.info("The total distance to the nearest monster through the city {}: {}",
                getCity().name(),
                distanceFromWitcherToCity + nearestDistanceFromCityToMonster);
    }
}
