package faang.school.godbless.BJS2_23905;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters);
        System.out.println("Nearest monster to " + city.getName() + "city is " + monster.getName());
        System.out.println("Time for kill is " + getKillTime());
        System.out.println("Journey distance is " + getJourneyDistance());

    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min(Comparator.comparingInt(monster -> city.getLocation().getDistanceTo(monster.getLocation())))
                .orElse(null);
    }

    public long getKillTime() {
        return (long) (Math.random() + 1) * 10;
    }

    public long getJourneyDistance() {
        return (long) city.getDistance();
    }
}
