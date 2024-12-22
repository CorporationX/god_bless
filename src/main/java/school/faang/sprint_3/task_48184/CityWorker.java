package school.faang.sprint_3.task_48184;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CityWorker implements Runnable {
    @NonNull
    private final City city;
    @NonNull
    private final List<Monster> monsters;

    @Override
    public void run() {
        Location witcherLocation = new Location(0, 0);
        double distanceFromWitcher = calculateDistance(witcherLocation);
        double distanceToNearestMonster = getDistanceToNearestMonster();

        String cityName = city.getName();
        System.out.printf("""
                        Distance from witcher to %s %.2f,
                        distance from %s to the nearest monster %.2f,
                        total distance %.2f
                        """,
                cityName,
                distanceFromWitcher,
                cityName,
                distanceToNearestMonster,
                distanceFromWitcher + distanceToNearestMonster);
    }

    private Double getDistanceToNearestMonster() {
        return monsters.stream()
                .map(monster -> calculateDistance(monster.getLocation()))
                .min(Double::compareTo)
                .orElse(0.0);
    }

    private double calculateDistance(Location location) {
        int distanceX = Math.abs(city.getLocation().x() - location.x());
        int distanceY = Math.abs(city.getLocation().y() - location.y());
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }
}
