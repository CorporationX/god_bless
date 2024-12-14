package school.faang.BJS236321;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private Castle castle;

    @Override
    public void run() {
        double distance = Math.sqrt(Math.pow(castle.getX2() - castle.getX1(), 2) + Math.pow(city.getY2() - city.getY1(), 2));
        double nearestDistance = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double distanceToMonster = Math.sqrt(Math.pow(monster.getX1() - city.getX1(), 2) + Math.pow(monster.getY1() - city.getY1(), 2));
            if (distanceToMonster < nearestDistance) {
                nearestDistance = distanceToMonster;
            }
        }
        double totalDistance = distance + nearestDistance;
        System.out.println("Маршрут: " + totalDistance + " единиц");
    }
}
