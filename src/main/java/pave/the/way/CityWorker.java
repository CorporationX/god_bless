package pave.the.way;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private static final double POW = 2.0;

    @Override
    public void run() {
        if (Objects.isNull(monsters) || Objects.isNull(city) || monsters.isEmpty()) {
            log.error("Null or empty arguments!");
            return;
        }

        double cityX = city.getLocation().getCoordinateX();
        double cityY = city.getLocation().getCoordinateY();
        double distanceToCity = Math.sqrt(Math.pow(cityX, POW) + Math.pow(cityY, POW));

        Double minimalDistanceToMonster = monsters.stream()
                .filter(Objects::nonNull)
                .map(monster -> Math.sqrt(Math.pow(monster.getLocation().getCoordinateX(), POW)
                        + Math.pow(monster.getLocation().getCoordinateY(), POW)))
                .map(distance -> distanceToCity - distance)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("No valid monsters found"));

        log.info("Расстояние от замка до города {} {}km : Расстояние от города {} до ближайшего монстра {}km.",
                city.getName(), distanceToCity, city.getName(), minimalDistanceToMonster);
    }
}
