package school.faang.BJS2_36332_FingerPath;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final Location WITCHER_LOCATION = new Location(0, 0);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    private City city;
    private List<Monster> monsters;

    private static double calculateDistance(Location first, Location second) {
        return Math.sqrt(
                Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2)
        );
    }

    @Override
    public void run() {
        if (monsters == null || monsters.isEmpty()) {
            log.info("No monsters found near the city {}.", city.getName());
            return;
        }

        double witcherCityDistance = calculateDistance(city.getLocation(), WITCHER_LOCATION);
        double minDistanceToMonster =
                monsters.stream()
                        .map(monster -> calculateDistance(monster.getLocation(), city.getLocation()))
                        .min(Comparator.naturalOrder())
                        .orElseThrow(() -> new IllegalStateException("No minimum distance found for monsters."));

        log.info(
                "Distance to city {}: {}, distance from city to nearest monster: {}, total distance: {}",
                city.getName(),
                DECIMAL_FORMAT.format(witcherCityDistance),
                DECIMAL_FORMAT.format(minDistanceToMonster),
                DECIMAL_FORMAT.format(witcherCityDistance + minDistanceToMonster)
        );
    }
}
