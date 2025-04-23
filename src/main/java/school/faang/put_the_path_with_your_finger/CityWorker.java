package school.faang.put_the_path_with_your_finger;

import java.util.List;

public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        double distanceToCity = calculateDistance(new Location(0, 0), city.getLocation());

        Monster nearestMonster = findNearestMonster();

        if (nearestMonster != null) {
            double distanceToMonster = calculateDistance(city.getLocation(), nearestMonster.getLocation());
            double totalDistance = distanceToCity + distanceToMonster;
            System.out.println("Город: " + city.getName() +
                    " | Монстр: " + nearestMonster.getName() +
                    " | Общая дистанция: " + totalDistance);
        } else {
            System.out.println("Город: " + city.getName() + " | Нет ближайших монстров");
        }
    }

    private Monster findNearestMonster() {
        if (monsters.isEmpty()) {
            return null;
        }

        Monster nearest = monsters.get(0);
        double minDistance = calculateDistance(city.getLocation(), nearest.getLocation());

        for (Monster monster : monsters) {
            double currentDistance = calculateDistance(city.getLocation(), monster.getLocation());
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                nearest = monster;
            }
        }

        return nearest;
    }

    private double calculateDistance(Location loc1, Location loc2) {
        double dx = loc1.getCoordX() - loc2.getCoordX();
        double dy = loc1.getCoordY() - loc2.getCoordY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
