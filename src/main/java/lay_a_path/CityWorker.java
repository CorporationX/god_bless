package lay_a_path;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private final static Location CASTLE = new Location(0, 0);

    private City city;
    private List<Monster> monsters;


    @Override
    public void run() {
        double distanceFromCastle = calculateDistanceFromStart(city.getLocation());
        Monster closestMonster = monsters.stream()
                .sorted((a, b) -> (int) (
                        calculateDistance(city.getLocation(), a.getLocation()) - calculateDistance(city.getLocation(), b.getLocation()))
                )
                .toList()
                .get(0);
        double targetDistance = calculateDistance(city.getLocation(), closestMonster.getLocation());
        System.out.printf("Расстояние от замка до монстра %s - %f%nОт замка до города %s - %f%nОт города до монстра - %f%n%n",
                closestMonster.getName(), distanceFromCastle + targetDistance, city.getName(), distanceFromCastle, targetDistance);

    }

    private double calculateDistance(Location location1, Location location2) {
        int dx = location2.getX() - location1.getX();
        int dy = location2.getY() - location1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    private double calculateDistanceFromStart(Location location) {
        return calculateDistance(location, CASTLE);
    }
}
