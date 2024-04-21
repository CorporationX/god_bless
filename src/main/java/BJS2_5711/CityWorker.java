package BJS2_5711;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        try {
            Monster monster = findNearestMonster(city, monsters);
            System.out.println("Ближайший монстр " + monster.getName() + "в " + monster.getLocation());
            System.out.println("Геральт идет до " + monster.getName());
            Thread.sleep(getJourneyDistance(monster.getLocation()));
            System.out.println("Геральт дерется с монстром");
            Thread.sleep(getKillTime());
            System.out.println("Геральт победил монстра. Великая победа орды");
        } catch (InterruptedException ex) {
            throw new RuntimeException("Something went wrong...");
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min(Comparator.comparing(mob -> Math.abs(city.getLocation().getX() - mob.getLocation().getX())
                        + Math.abs(city.getLocation().getY() - mob.getLocation().getY())))
                .orElseThrow(() -> new RuntimeException("Something went wrong"));
    }

    public long getKillTime() {
        return new Random().nextInt(3000, 6000);
    }

    public long getJourneyDistance(Location location) {
        return Math.abs(city.getLocation().getX() - location.getX())
                + Math.abs(city.getLocation().getY() - location.getY());
    }
}
