package school.faang.magic.map;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final Location WITCHER_LOCATION = new Location(0, 0);

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Location cityLocation = city.getLocation();
        double distanceToCity = calculateDistance(cityLocation, WITCHER_LOCATION);
        double minDistanceToMonster = monsters.stream()
                .map(monster -> calculateDistance(monster.getLocation(), city.getLocation()))
                .min(Double::compare)
                .orElseThrow(() -> new IllegalStateException("Монстров в близи города не обнаружено"));
        double totalDistance = distanceToCity + minDistanceToMonster;
        System.out.println("Расстояние до ближайшего монстра если отправляться в "
                + city.getName() + ": " + totalDistance);
    }

    private double calculateDistance(Location to, Location from) {
        return Math.sqrt(Math.pow(to.getX() - from.getX(), 2) +
                Math.pow(to.getY() - from.getY(), 2));
    }
}
