package school.faang.make_path_with_finger_BJS2_36296;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final double START_LOCATION_X = 0.0;
    private static final double START_LOCATION_Y = 0.0;

    private City city;
    private List<Monster> monsterList;
    private final Location witcherCastle = new Location(START_LOCATION_X, START_LOCATION_Y);

    @Override
    public void run() {
        double closestMonster = monsterList.stream()
                .map(monster -> calculateDistance(city.getLocation(), monster.getLocation()))
                .min(Double::compareTo)
                .orElse(0.0);

        double distanceToCity = calculateDistance(witcherCastle, city.getLocation());
        log.info(String.format("Дистанция до города: %.2f, Дистанция до ближайшего монстра: %.2f",
                distanceToCity, closestMonster));
    }

    private double calculateDistance(Location loc1, Location loc2) {
        double deltaX = loc1.getX() - loc2.getX();
        double deltaY = loc1.getY() - loc2.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
