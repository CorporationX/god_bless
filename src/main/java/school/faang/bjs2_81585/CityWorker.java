package school.faang.bjs2_81585;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final Location KAER_MORHEN = new Location(0, 0);
    private final City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double distanceToCity = calculateDistance(KAER_MORHEN, city.location());

        monsters.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        monster -> calculateDistance(city.location(), monster.location())))
                .entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .ifPresent(entry -> log.info(
                        "До города {} - {}; от города до ближайшего монстра {} - {}; общее расстояние - {}",
                        city.name(), distanceToCity, entry.getKey().name(), entry.getValue(),
                        distanceToCity + entry.getValue()));
    }

    public double calculateDistance(Location startLocation, Location targetLocation) {
        int distanceX = startLocation.getCoordX() - targetLocation.getCoordX();
        int distanceY = startLocation.getCoordY() - targetLocation.getCoordY();
        return (double) Math.round(Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)) * 100) / 100;
    }
}
