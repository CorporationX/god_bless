package school.faang.putfingeronpath;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Slf4j
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Location castleLocation = new Location(0, 0);
        double distanceToCity = castleLocation.distanceTo(city.getLocation());

        if (monsters.isEmpty()) {
            throw new IllegalStateException("Список монстров пуст");
        }

        Monster nearMonster = monsters.stream()
                .min((m1, m2) -> {
                    double d1 = city.getLocation().distanceTo(m1.getLocation());
                    double d2 = city.getLocation().distanceTo(m2.getLocation());
                    return Double.compare(d1, d2);
                })
                .orElseThrow(() -> new IllegalStateException("Не удалось определить ближайшего монстра"));

        double minDistance = city.getLocation().distanceTo(nearMonster.getLocation());
        double totalDistance = distanceToCity + minDistance;
        log.info("Маршрут: от замка до города {} = {}, от города {} до монстра {} = {}, общий путь = {}",
                city.getName(), String.format("%.2f", distanceToCity),
                city.getName(), nearMonster.getName(), String.format("%.2f", minDistance),
                String.format("%.2f", totalDistance)
        );
    }
}
