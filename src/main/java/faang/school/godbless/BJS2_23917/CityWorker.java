package faang.school.godbless.BJS2_23917;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> listOfMonsters = new ArrayList<>();

    @Override
    public void run() {
        Monster closestMonster = closestMonster();
        System.out.println("City: " + city.getName());
        System.out.println(closestMonster);
        double timeOfTheJourney = 2 * city.getLocation().timeTo(closestMonster.getLocation())
                + closestMonster.getTimeToKill();
        System.out.println("The total amount of Journey: " + timeOfTheJourney);
        System.out.println("------------------------------");
    }

    public Monster closestMonster() {
        if (listOfMonsters.isEmpty()) {
            throw new RuntimeException("No monsters available!");
        }

        Monster closestMonster = listOfMonsters.get(0);
        double closestDistance = city.getLocation().countDistance(city.getLocation(), closestMonster.getLocation());

        for (Monster monster : listOfMonsters) {
            double distance = city.getLocation().countDistance(city.getLocation(), monster.getLocation());
            if (distance < closestDistance) {
                closestMonster = monster;
                closestDistance = distance;
            }
        }

        return closestMonster;
    }
}