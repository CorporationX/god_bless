package faang.school.godbless.fingerpath;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println(String.format("%s nearest monster is %s", city.getName(), findNearestMonster().getName()));
        System.out.println(String.format("Kill time is %d minutes", getKillTime()));
        System.out.println(String.format("Journey distance to %s is %d meters", city.getName(), getJourneyDistance()));
    }

    public Monster findNearestMonster() {
        validateList(monsters);
        Monster nearestMonster = null;
        double shortestDistance = Double.MAX_VALUE;
        for (Monster monster : monsters) {
            double distance = getDistanceBetweenLocations(city.getLocation(), monster.getLocationCoordinates());
            if (distance < shortestDistance) {
                nearestMonster = monster;
                shortestDistance = distance;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return (int) ((Math.random() * 25) + 1);
    }

    public long getJourneyDistance() {
        return city.getDistanceToWitcher();
    }

    private double getDistanceBetweenLocations(Location location1, Location location2) {
        return Math.sqrt(Math.pow(location2.getX() - location1.getX(), 2) + Math.pow(location2.getY() - location1.getY(), 2));
    }

    private void validateList(List<?> list) {
        if (list == null) {
            throw new IllegalArgumentException("List can't be null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty");
        }
    }
}
