package school.faang.sprint3.witcher;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CityWorker implements Runnable {
    private static final Location WITCHER_LOCATION = new Location(0D, 0D);
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Location cityLocation = city.getLocation();
        Double cityDistance = getDistance(cityLocation, WITCHER_LOCATION);
        Optional<Monster> nearestMonsterToCity = monsters.stream()
                .min(Comparator.comparingDouble(monster -> getDistance(monster.getLocation(), cityLocation)));
        nearestMonsterToCity.ifPresent(monster ->
                System.out.printf("Расстояние до монтра, посчитанное потоком %f, = %s\n",
                        cityDistance + getDistance(monster.getLocation(), cityLocation),
                        Thread.currentThread().getName()
                )
        );
    }

    private Double getDistance(Location location1, Location location2) {
        return Math.sqrt(Math.pow(location1.getHorizontalCoordinate() - location2.getHorizontalCoordinate(), 2)
                + (Math.pow(location1.getVerticalCoordinate() - location2.getVerticalCoordinate(), 2)));
    }
}
