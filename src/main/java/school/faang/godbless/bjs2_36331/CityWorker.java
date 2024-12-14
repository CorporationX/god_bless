package school.faang.godbless.bjs2_36331;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double distance = getDistance(new Location(0, 0), city.getLocation()) +
                monsters.stream().mapToDouble(m -> getDistance(m.getLocation(), city.getLocation())).min().orElse(0);
        log.info("Distance: {}", distance);
    }

    private double getDistance(Location a, Location b) {
        return Math.sqrt(Math.pow(Math.abs(a.getX() - b.getX()), 2) + Math.pow(Math.abs(a.getY() - b.getY()), 2));
    }
}
