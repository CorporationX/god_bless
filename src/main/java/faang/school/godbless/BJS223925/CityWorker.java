package faang.school.godbless.BJS223925;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster closestMonster = findClosestMonster();
        int timeToKillMonster = calculateTimeToKillMonster(closestMonster);
        int totalTime = calculateTotalTravelTime(timeToKillMonster);

        System.out.println("Геральт в городе " + city.getName() + " убивает монстра " + closestMonster.getName()
                + ". Общее время: " + totalTime + " миллисекунд");
    }

    private Monster findClosestMonster() {
        return monsters.stream()
                .min((monster1, monster2) -> calculateDistance(city.getDistances().get(0), monster1.getLocation())
                        - calculateDistance(city.getDistances().get(0), monster2.getLocation()))
                .orElseThrow();
    }

    private int calculateDistance(Location cityLocation, Location monsterLocation) {
        return Math.abs(cityLocation.getX() - monsterLocation.getX()) + Math.abs(cityLocation.getY() - monsterLocation.getY());
    }

    private int calculateTimeToKillMonster(Monster monster) {
        return monster.getName().length() * 8;
    }

    private int calculateTotalTravelTime(int timeToKillMonster) {
        return timeToKillMonster + city.getDistances().stream()
                .mapToInt(location -> Math.abs(location.getX()) + Math.abs(location.getY()))
                .sum();
    }
}
