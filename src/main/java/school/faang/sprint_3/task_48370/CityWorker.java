package school.faang.sprint_3.task_48370;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CityWorker implements Runnable {
    public static final Location CASTLE = new Location(0, 0);
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        ValidationUtils.isNotNull(city, "Город");
        double distanceToCity = calculateDistance(CASTLE, city.location());

        Map.Entry<Monster, Double> monsterDistance = getNearestMonster(monsters, city.location());
        Monster nearestMonster = monsterDistance.getKey();
        Double nearestDistance = monsterDistance.getValue();

        double totalDistance = distanceToCity + nearestDistance;

        System.out.printf("Минимальное расстояние до города %s и до ближайшего монстра %s составляет - %.2f метра\n",
                city.name(), nearestMonster.name(), totalDistance);
    }

    private double calculateDistance(Location loc1, Location loc2) {
        ValidationUtils.isNotNull(loc1, "Локация №1");
        ValidationUtils.isNotNull(loc2, "Локация №2");

        int deltaX = loc1.x() - loc2.x();
        int deltaY = loc1.y() - loc2.y();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    private Map.Entry<Monster, Double> getNearestMonster(List<Monster> monsters, Location location) {
        ValidationUtils.isNotNull(monsters, "Список монстров");
        ValidationUtils.isNotNull(location, "Локация");

        return monsters.stream()
                .collect(Collectors.toMap(
                        monster -> monster,
                        monster -> calculateDistance(location, monster.location())
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalStateException("Ближайший монстр не определен"));
    }
}
