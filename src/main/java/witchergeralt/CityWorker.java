package witchergeralt;

import lombok.Getter;

import java.util.List;
import java.util.logging.Logger;

@Getter
public class CityWorker implements Runnable {
    private static final Logger logger = Logger.getLogger(CityWorker.class.getName());
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        try {
            logger.info("Magic map is starting to searching! Please, wait for results!");
            Thread.sleep(2000);
            double cityDistance = calculateDistance(0, 0, city.location().x(), city.location().y());
            Monster nearestMonster = findNearestMonster(city);
            double monsterDistance = calculateDistance(city.location().x(), city.location().y(),
                    nearestMonster.location().x(), nearestMonster.location().y());
            double totalDistance = cityDistance + monsterDistance;
            logger.info(String.format("From the castle to %s: %.2f km. " +
                            "Distance from %s to the nearest monster (%s): %.2f km. Total distance: %.2f km.",
                    city.name(), cityDistance, city.name(), nearestMonster.name(), monsterDistance, totalDistance));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warning("Interrupted! Something went wrong!");
        }
    }

    private double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private Monster findNearestMonster(City city) {
        return monsters.stream()
                .min((m1, m2) -> Double.compare(
                        calculateDistance(city.location().x(), city.location().y(),
                                m1.location().x(), m1.location().y()),
                        calculateDistance(city.location().x(), city.location().y(),
                                m2.location().x(), m2.location().y())))
                .orElseThrow(() -> new RuntimeException("No monsters found"));
    }
}
