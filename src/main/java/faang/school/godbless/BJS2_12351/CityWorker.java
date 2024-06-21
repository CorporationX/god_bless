package faang.school.godbless.BJS2_12351;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster monster = findNearestMonster();
        String nameOfCurrentThread = Thread.currentThread().getName();

        System.out.printf("%s: nearest monster detected: %s\n", nameOfCurrentThread, monster.getName());
        try {
            System.out.printf("%s: killing monster '%s'...\n", nameOfCurrentThread, monster.getName());
            Thread.sleep(getKillTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("%s killing monster '%s' failed", nameOfCurrentThread, monster.getName()));
        }
        System.out.printf("%s: monster '%s' dead\n", nameOfCurrentThread, monster.getName());
    }

    public Monster findNearestMonster() {
        return monsters.stream().min((monster1, monster2) -> Double.compare(findDistanceFormula(monster1, city),
                findDistanceFormula(monster2, city))).orElse(new Monster("default", new Location(0, 0)));
    }

    public long getKillTime() {
        return new Random().nextInt(2000, 3000);
    }

    public long getJourneyDistance() {
        return city.getDictation();
    }

    private double findDistanceFormula(Monster monster, City city) {
        return Math.sqrt(
                Math.pow(city.getLocation().getX() - monster.getLocation().getX(), 2)
                        +
                Math.pow(city.getLocation().getY() - monster.getLocation().getY(), 2)
        );
    }
}