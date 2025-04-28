package school.faang.magicmap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;
    private final Location castleLocation = new Location(0, 0);

    @Override
    public void run() {
        double distanceToCity = calculateDistance(castleLocation, city.getLocation());

        Monster nearestMonster = monsters.stream()
                .min((monster1, monster2) -> Double.compare(
                        calculateDistance(city.getLocation(), monster1.getLocation()),
                        calculateDistance(city.getLocation(), monster2.getLocation())
                ))
                .orElse(null);

        if (nearestMonster == null) {
            log.warn("No monsters found near {}", city.getName());
            return;
        }

        double distanceToNearestMonster = calculateDistance(city.getLocation(), nearestMonster.getLocation());

        log.info("Nearest monster to {} is {}. Distance from castle to city: {}, from city to monster {}",
                city.getName(), nearestMonster.getName(), distanceToCity, distanceToNearestMonster);
    }

    private double calculateDistance(Location location1, Location location2) {
        double deltaX = location1.getLatitude() - location2.getLatitude();
        double deltaY = location1.getLongitude() - location2.getLongitude();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}