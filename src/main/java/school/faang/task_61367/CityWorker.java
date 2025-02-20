package school.faang.task_61367;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final Location WITCHER = new Location(0, 0);
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        double cityDistance = calculateDistance(WITCHER, city.getLocation());

        Monster closestMonster = null;
        double minDistance = Double.MAX_VALUE;
        for (Monster monster : monsters) {
            double monsterDistance = calculateDistance(monster.getLocation(), city.getLocation());
            if (monsterDistance < minDistance) {
                minDistance = monsterDistance;
                closestMonster = monster;
            }
        }

        if (closestMonster == null) {
            throw new RuntimeException("Monster cant be null\n");
        }

        double distance = minDistance + cityDistance;

        System.out.printf("The monster is not far from the city: %s - %s\n",
                city.getName(), closestMonster.getName());
        System.out.println();
        System.out.printf("The distance to the monster %s: %.2f, city: %s\n",
                closestMonster.getName(), distance, city.getName());
    }

    private double calculateDistance(Location loc1, Location loc2) {
        int deltaX = loc1.getPositionX() - loc2.getPositionX();
        int deltaY = loc1.getPositionY() - loc2.getPositionY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
