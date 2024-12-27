package school.faang.bjs248205;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;
    private static final Location CASTLE = new Location(0.0, 0.0);

    @Override
    public void run() {
        double distanceToCity = calculateDistance(CASTLE, city.getLocation());

        Map.Entry<Monster, Double> monsterDistance = getNearestMonster(monsters, city.getLocation());
        Monster nearestMonster = monsterDistance.getKey();
        Double nearestDistance = monsterDistance.getValue();
        double totalDistance = distanceToCity + nearestDistance;

        log.info("The minimum distance to the city {} and to the nearest monster {} is {} meters",
                city.name(), nearestMonster.name(), totalDistance);
    }

    private static double calculateDistance(Location locationInit, Location locationFin) {
        double deltaX = locationFin.x() - locationInit.x();
        double deltaY = locationFin.y() - locationInit.y();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    private Map.Entry<Monster, Double> getNearestMonster(List<Monster> monsters, Location location) {
        if (monsters.isEmpty()) {
            throw new IllegalStateException("Monster cannot be empty");
        }

        return monsters.stream()
                .collect(Collectors.toMap(
                        monster -> monster,
                        monster -> calculateDistance(location, monster.location())
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalStateException("Nearest monster not found"));
    }


}
