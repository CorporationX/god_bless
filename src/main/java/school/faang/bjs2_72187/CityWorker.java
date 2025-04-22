package school.faang.bjs2_72187;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
        double distanceToTheCity = calculateTheDistance(this.startLocation, this.city.location());

        Optional<MonsterDistance> monsterWithMinDistances = monsters.stream()
            .collect(Collectors.toMap(
                Monster::name, monster -> calculateTheDistance(this.city.location(), monster.location())
            ))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .map(s -> new MonsterDistance(s.getKey(), s.getValue()))
            .findFirst();

        monsterWithMinDistances.ifPresent(
            monster ->
                log.info("Distance to the nearest monster {} with city {} is: {}",
                    monster.monsterName(), this.city.name(), distanceToTheCity + monster.distance())
        );
    }

    private double calculateTheDistance(Location firstPoint, Location secondPoint) {
        int deltaX = firstPoint.cordX() - secondPoint.cordX();
        int deltaY = firstPoint.cordY() - secondPoint.cordY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
