package school.faang.m1s3.bjs2_36309_witcher;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class CityWorker implements Runnable {
    private final Witcher witcher;
    private final City city;
    private final List<Monster> monsters;
    private Map<CityMonsterKey, Double> nearestMonster = new HashMap<>();

    @Override
    public void run() {
        double distanceToCity = calculateDistance(witcher.getWitcherLocation(), city);
        monsters.stream()
                .collect(Collectors.toMap(m -> m, m -> calculateDistance(city, m)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(1)
                .forEach(entry ->
                        nearestMonster.put(new CityMonsterKey(city, entry.getKey()), entry.getValue() + distanceToCity));
    }

    private double calculateDistance(Location startLocation, Location endLocation) {
        double a = Math.abs(startLocation.getX() - endLocation.getX());
        double b = Math.abs(startLocation.getY() - endLocation.getY());
        double result = Math.sqrt(a * a + b * b);
        return Math.round(result);
    }
}
