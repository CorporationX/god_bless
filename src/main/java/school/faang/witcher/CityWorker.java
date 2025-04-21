package school.faang.witcher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;
    private final Location castleLocation = new Location(0, 0);

    @Override
    public void run() {
        Target target = this.monsters.stream()
                .map(monster -> new Target(monster,
                        distance(city.location(), monster.location()) + distance(castleLocation, castleLocation)))
                .min(Comparator.comparingDouble(Target::distance))
                .orElseThrow(() ->
                        new IllegalStateException("Fail to calculate nearest monster for city %s"
                                .formatted(city.name())));
        log.info("Nearest target is {}, its {} meters away from witcher near {}",
                target.monster().name(),
                String.format("%.1f", target.distance()),
                city.name());

    }

    private double distance(Location cityLocation, Location monsterLocation) {
        double deltaX = cityLocation.x() - monsterLocation.x();
        double deltaY = cityLocation.y() - monsterLocation.y();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
