package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.utils.ValidationUtil;

import java.util.List;

public class CityWorker implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(CityWorker.class);
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        ValidationUtil.isValidCity(city);
        ValidationUtil.isValidList(monsters, "Monster");
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        double distanceToCity = calculateDistance(new Location(0, 0), city.getLocation());
        double shortestDistance = Double.MAX_VALUE;
        Monster nearestMonster = null;

        for (Monster monster : monsters) {
            double currentDistance = calculateDistance(city.getLocation(), monster.getLocation());
            if (shortestDistance > currentDistance) {
                shortestDistance = currentDistance;
                nearestMonster = monster;
            }
        }

        if (nearestMonster == null) {
            logger.error("No monsters near the {}.", city.getName());
        } else {
            logger.info("City {}, monster {}, total distance {}.",
                    city.getName(), nearestMonster.getName(), shortestDistance + distanceToCity);
        }
    }

    private double calculateDistance(Location start, Location end) {
        return Math.sqrt(Math.pow(start.getPosX() - end.getPosX(), 2) + Math.pow(start.getPosY() - end.getPosY(), 2));
    }
}
