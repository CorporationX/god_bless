package faang.school.godbless.FingerYourWay;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min(Comparator.comparingDouble(i -> Math.sqrt(Math.pow(
                        (city.getLocation().getX() - i.getLocation().getX()), 2) +
                        Math.pow((city.getLocation().getY() - i.getLocation().getY()), 2))))
                .orElse(null);
    }

    public long getKillTime() {
        return new Random().nextInt(5, 30);
    }


    public long getJourneyDistance(Monster monster) {
        return (long) Math.sqrt(Math.pow(
                (monster.getLocation().getX()), 2) +
                Math.pow((monster.getLocation().getY()), 2));
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters);
        System.out.println("Ближайший монстр - " + monster.getName());
        long killTime = getKillTime();
        System.out.println("Бой длится - " + killTime + " часов");
        try {
            Thread.sleep(killTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long walkTime = getJourneyDistance(monster);
        System.out.println("Дистанция до цели - " + walkTime);


    }
}
