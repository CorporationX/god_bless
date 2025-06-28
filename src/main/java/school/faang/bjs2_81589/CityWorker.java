package school.faang.bjs2_81589;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double distanceToCity = calculateDistance(new Location(0, 0), city.location());
        double distanceToMonster = monsters.stream()
                .map(monster -> calculateDistance(city.location(), monster.location()))
                .min(Double::compareTo).orElse(0.0);

        System.out.printf("Distance to city %s: %s, distance to monster: %s%n",
                city.name(), distanceToCity, distanceToMonster);
    }

    public double calculateDistance(Location start, Location end) {
        return Math.sqrt(Math.pow(end.x() - start.x(), 2) + Math.pow(end.y() - start.y(), 2));
    }
}
