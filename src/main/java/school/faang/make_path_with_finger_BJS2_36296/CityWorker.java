package school.faang.make_path_with_finger_BJS2_36296;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Data
@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final Logger logger = Logger.getLogger(CityWorker.class.getName());
    private static final double START_LOCATION_X = 0.0;
    private static final double START_LOCATION_Y = 0.0;

    private City city;
    private List<Monster> monsterList;
    private final Location witcherCastle = new Location(START_LOCATION_X, START_LOCATION_Y);

    @Override
    public void run() {
        List<Double> distances = new ArrayList<>();
        for (Monster monster : monsterList) {
            distances.add(calculateDistance(city.getLocation(), monster.getLocation()));
        }

        double closestMonster = distances.stream()
                .mapToDouble(Double::doubleValue)
                .min()
                .orElse(0.0);
        double distanceToCity = calculateDistance(witcherCastle, city.getLocation());
        logger.info(String.format("Дистанция до города: %.2f, Дистанция до ближайшего монстра: %.2f",
                distanceToCity, closestMonster));
    }

    private double calculateDistance(Location loc1, Location loc2) {
        double deltaX = loc1.getX() - loc2.getX();
        double deltaY = loc1.getY() - loc2.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
