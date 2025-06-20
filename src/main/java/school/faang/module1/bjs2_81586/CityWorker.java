package school.faang.module1.bjs2_81586;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    private static final Location WITCHER_CASTLE = new Location(0, 0);

    @Override
    public void run() {
        double distanceToCity = calculateDistance(WITCHER_CASTLE, city.getLocation());
        Optional<Monster> nearestMonsterOpt = monsters.stream()
                .min(Comparator.comparingDouble(
                        monster -> calculateDistance(city.getLocation(), monster.getLocation())
                ));
        if (nearestMonsterOpt.isPresent()) {
            Monster nearestMonster = nearestMonsterOpt.get();
            double distanceToMonster = calculateDistance(city.getLocation(), nearestMonster.getLocation());
            log.info(
                    "Расстояние от замка до города: {}. Расстояние От города до ближайшего монстра: {}",
                    distanceToCity,
                    distanceToMonster
            );
        } else {
            log.info("Для города {} не найдено ни одного монстра", city.getName());
        }
    }

    private double calculateDistance(Location location1, Location location2) {
        int deltaX = location1.getCoordinateX() - location2.getCoordinateX();
        int deltaY = location1.getCoordinateY() - location2.getCoordinateY();
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return Math.round(distance * 100.0) / 100.0;
    }
}