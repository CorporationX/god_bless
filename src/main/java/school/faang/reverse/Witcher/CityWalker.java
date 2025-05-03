package school.faang.reverse.Witcher;

import lombok.Getter;

import java.util.List;

@Getter
class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        Location castleLocation = new Location(0, 0);
        double distanceToCity = Math.sqrt(Math.pow(city.getLocation().getX() - castleLocation.getX(), 2) +
                Math.pow(city.getLocation().getY() - castleLocation.getY(), 2));

        Monster closestMonster = null;
        double minDistanceToMonster = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double distanceToMonster = Math.sqrt(Math.pow(monster.getLocation().getX() - city.getLocation().getX(), 2) +
                    Math.pow(monster.getLocation().getY() - city.getLocation().getY(), 2));
            if (distanceToMonster < minDistanceToMonster) {
                minDistanceToMonster = distanceToMonster;
                closestMonster = monster;
            }
        }

        double totalDistance = distanceToCity + minDistanceToMonster;
        System.out.printf(city.getName(), distanceToCity, minDistanceToMonster, totalDistance);
    }
}
