package bjs2_35733;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Location castleLocation = new Location(0, 0);
        Location cityLocation = city.getLocation();
        double witcherCastleCityDistance = computeDistance(castleLocation, cityLocation);
        double closestToCityMonsterDistance = computeClosestToCityMonsterDistance();

        System.out.printf("Distnce from witcher castle to %s and closest monster: %f\n",
                city.getName(), witcherCastleCityDistance + closestToCityMonsterDistance);
    }

    private double computeDistance(Location startLocation, Location endLocation) {
        int xDistance = startLocation.getX() - endLocation.getX();
        int yDistance = startLocation.getY() - endLocation.getY();
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    private double computeClosestToCityMonsterDistance() {
        double closestToCityMonsterDistance = Double.MIN_VALUE;

        for (Monster monster : monsters) {
            double monsterCityDistance = computeDistance(city.getLocation(), monster.getLocation());

            if (monsterCityDistance < closestToCityMonsterDistance) {
                closestToCityMonsterDistance = monsterCityDistance;
            }
        }
        return closestToCityMonsterDistance;
    }
}
