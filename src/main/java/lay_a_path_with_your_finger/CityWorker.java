package lay_a_path_with_your_finger;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private static final Location THE_WITCHERS_CASTLE = new Location(0, 0);

    /**
     * Find all monsters within a certain distance of the city and print their distance from the Witcher's castle.
     */
    @Override
    public void run() {
        var city_location = city.getLocation();
        var distance_of_city = calculateDistance(city_location, THE_WITCHERS_CASTLE);

        monsters.forEach(monster -> {
            double monster_distance = calculateDistance(monster.getLocation(), city_location);
            monster.setDistanceFromCity(monster_distance);
        });

        monsters.stream().filter(monster -> monster.getDistanceFromCity() <= distance_of_city).forEach(monster -> {
            System.out.printf("Расстояние от замка до мостра - %s: %.2f%n", monster.getName(), monster.getDistanceFromCity() + distance_of_city);
        });
    }

    /**
     * Calculate the Euclidean distance between two points.
     *
     * @param point1 first point
     * @param point2 second point
     * @return the Euclidean distance
     */
    private double calculateDistance(Location point1, Location point2) {
        return Math.sqrt(Math.pow((point1.getY() - point2.getY()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }
}
