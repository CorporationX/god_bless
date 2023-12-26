package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Ближайший монстр к " + city.getName() + " - " + findNearestMonster().getName());
        System.out.println("Время на убийство: " + getKillTime());
        System.out.println("Расстояние до "+city.getName()+"-"+getJourneyDistance());
    }

    public Monster findNearestMonster() {
        Location cityLocation = city.getLocation();
        Monster nearMonster = null;
        int distance = Integer.MAX_VALUE;
        for (Monster monster : monsters) {
            Location monsterLocation = monster.getLocationMonster();

            int x = Math.abs(cityLocation.getX() - monsterLocation.getX());
            int y = Math.abs(cityLocation.getY() - monsterLocation.getY());
            int sum = x + y;
            if (sum < distance) {
                distance = sum;
                nearMonster = monster;
            }
        }
        return nearMonster;

    }

    public int getKillTime() {
        var time = 0;
        switch (findNearestMonster().getName()) {
            case "Griffin" -> time = 40;
            case "Basilisk" -> time = 30;
            case "Cockatrice" -> time = 20;
            case "Chort" -> time = 15;
        }
        return time;
    }

    public int getJourneyDistance() {
        return city.getDistance();
    }
}
