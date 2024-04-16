package faang.school.godbless.multithreading.task_7.model;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;


    @Override
    public void run() {
        System.out.println("ближайший монстр к городу " + city.getName() + " " + findNearestMonster(city, monsters));
        System.out.println("времени на убийство монстра потрачено: " + getKillTime());
        System.out.println("расстояние до города: " + getJourneyDistance());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = null;
        int currentLocation = Integer.MAX_VALUE;
        Location cityLocation = city.getLocation();
        for (Monster beast : monsters) {
            int distanceFromCity = getDistance(cityLocation, beast.getCoordinatesByHabitat(beast.getHabitat()));
            if (currentLocation > distanceFromCity) {
                currentLocation = distanceFromCity;
                nearestMonster = beast;
            }
        }

        return nearestMonster;
    }

    private static int getDistance(Location from, Location to) {
        int deltaX = (int) Math.pow(to.getX() - from.getX(), 2);
        int deltaY = (int) Math.pow(to.getY() - from.getX(), 2);
        return (int) Math.sqrt(deltaX + deltaY);
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 10);
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }
}
