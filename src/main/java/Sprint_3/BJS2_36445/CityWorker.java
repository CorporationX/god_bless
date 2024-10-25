package Sprint_3.BJS2_36445;

import java.util.List;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    private double calculateDistance(Location loc1, Location loc2) {
        int x1 = loc1.getX();
        int y1 = loc1.getY();
        int x2 = loc2.getX();
        int y2 = loc2.getY();
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    @Override
    public void run() {
        Location cityLocation = city.getLocation();
        Location witcherCastle = new Location(0, 0);
        double distanceToCity = calculateDistance(cityLocation, witcherCastle);
        System.out.println("Distance from witcher castle to : " + city.getName() + ": " + distanceToCity + " Units.");

        Monster closestMonster = null;
        double minDistance = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double distance = calculateDistance(cityLocation, monster.getLocation());
            if (distance < minDistance) {
                minDistance = distance;
                closestMonster = monster;
            }
        }

        double totalDistance = distanceToCity + minDistance;

        if (closestMonster != null) {
            System.out.println("Total route distance (Witcher's castle -> " + city.getName() + " -> " +
                    closestMonster.getName() + "): " + totalDistance + " units.");
        } else {
            System.out.println("No monsters found near " + city.getName());
        }
    }

}
