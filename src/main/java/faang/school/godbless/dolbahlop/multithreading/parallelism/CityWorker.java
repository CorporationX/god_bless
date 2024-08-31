package faang.school.godbless.dolbahlop.multithreading.parallelism;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster monster = findClosestMonster(city, monsters);
        System.out.println("Nearest monster to " + city.getCityName() + "city is " + monster.getMonsterName());
        System.out.println("Time for kill is " + getKillTime());
        System.out.println("Journey distance is " + getJourneyDistance());
    }

    public Monster findClosestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min(Comparator.comparingInt(monster -> city.getLocation().getDistanceTo(monster.getLocation())))
                .orElse(null);
    }

    public long getKillTime() {
        return (long) (Math.random() + 1) * 11;
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }
}
