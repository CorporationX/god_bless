package school.faang.witcher.magic.map;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private Location witcherLocation;
    static double bestDistance = Double.POSITIVE_INFINITY;

    @Override
    public void run() {
        double distance = monsters.stream()
                .mapToDouble(monster -> Location.distance(city.getLocation(), monster.getLocation()))
                .min()
                .orElseThrow(IllegalArgumentException::new);

        distance += Location.distance(witcherLocation, city.getLocation());

        if (distance < bestDistance) { bestDistance = distance; }
    }
}
