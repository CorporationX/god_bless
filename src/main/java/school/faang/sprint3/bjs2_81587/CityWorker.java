package school.faang.sprint3.bjs2_81587;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double distanceToCity = Location.calculateDistance(new Location(0, 0), city.getLocation());
        double closestDistanceToMonster = monsters.stream()
                .map(monster -> city.getLocation().calculateDistance(monster.getLocation()))
                .sorted()
                .findFirst()
                .orElse(distanceToCity);

        System.out.printf(
                "Расстояние до города: %s, расстояние от города до монстра: %s\n",
                distanceToCity,
                closestDistanceToMonster
        );
    }
}
