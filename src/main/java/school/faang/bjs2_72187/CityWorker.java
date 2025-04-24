package school.faang.bjs2_72187;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private final Location startLocation;
    private final City city;
    private final List<Monster> monsters;

    /**
     * Метод рассчитывает расстояние от замка Ведьмака (Location startLocation) до города.
     * Находит ближайшего к этому городу монстра.
     * Выводит на консоль маршрут: расстояние от замка до города плюс расстояние от города до ближайшего монстра.
     */
    @Override
    public void run() {
        double distanceToTheCity = calculateDistance(this.startLocation, this.city.location());

        Optional<MonsterDistance> monsterWithMinDistances = monsters.stream()
            .min(Comparator.comparingDouble(monster ->
                calculateDistance(this.city.location(), monster.location())))
            .map(monster -> new MonsterDistance(monster.name(),
                calculateDistance(this.city.location(), monster.location())));

        monsterWithMinDistances.ifPresent(
            monster ->
                log.info("Distance to the nearest monster {} with city {} is: {}",
                    monster.monsterName(), this.city.name(), distanceToTheCity + monster.distance())
        );
    }

    private double calculateDistance(Location firstPoint, Location secondPoint) {
        if (firstPoint == null || secondPoint == null) {
            throw new IllegalArgumentException("Locations cannot be null");
        }
        int deltaX = firstPoint.cordX() - secondPoint.cordX();
        int deltaY = firstPoint.cordY() - secondPoint.cordY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
