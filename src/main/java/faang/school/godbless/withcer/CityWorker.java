package faang.school.godbless.withcer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    private double getDistance(Location start, Location end) {
        return Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
    }

    public long getJourneyDistance(Location target) {
        return (long) getDistance(city.getLocation(), target);
    }

    public long getKillingTime() {
        return new Random().nextInt(1001) + 1000;
    }

    public Monster findNearestMonster(Location location, List<Monster> monsters) {
        return monsters.stream().min(Comparator.comparing(monster -> getDistance(monster.getLocation(), location)))
                .orElseThrow(() -> new RuntimeException("Монстров нет"));
    }

    @Override
    public void run() {
        try {
            Monster monster = findNearestMonster(city.getLocation(), monsters);
            System.out.println("Ближайший монстр к городу " + city.getName() + " это " + monster.getName());
            Thread.sleep(getJourneyDistance(monster.getLocation()));
            System.out.println("Сражение с " + monster.getName() + " началось");
            Thread.sleep(getKillingTime());
            System.out.println(monster.getName() + " побеждён");
        }
        catch (InterruptedException e){
            System.out.println("Что то пошло не так(");
        }
    }
}
