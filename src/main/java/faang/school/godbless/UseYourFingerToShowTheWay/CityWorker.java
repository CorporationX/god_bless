package faang.school.godbless.UseYourFingerToShowTheWay;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        int travelTime = calculateTravelTime(nearestMonster);
        System.out.println("In " + city.getName() + " nearest monster is " + nearestMonster.getName() +
                ". Travel time: " + travelTime + " minutes.");
    }

    private Monster findNearestMonster() {
        return monsters.stream()
                .min((monster1, monster2) -> Integer.compare(
                        city.getDistanceTo(monster1.getLocation()),
                        city.getDistanceTo(monster2.getLocation())))
                .orElse(null);
    }

    private int calculateTravelTime(Monster monster) {
        return city.getDistanceTo(monster.getLocation());
    }
}
