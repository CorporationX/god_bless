package faang.school.godbless.paveTheWayWithYourFinger;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("City " + city.getName()
                + " is in " + getJourneyDistance()
                + " days distance from you. Nearest monster to the city is "
                + findNearestMonster().getName()
                + ". And time you need to kill them is "
                + getKillTime()+".");
    }

    public Monster findNearestMonster() {
        return monsters.stream().collect(Collectors.toMap(
                        monster -> monster,
                        monster -> distanceToMonster(monster, city)
                )).entrySet().stream().min(Map.Entry.comparingByValue())
                .get().getKey();
    }

    public long getKillTime() {
        return new Random().nextLong(5001);
    }

    public long getJourneyDistance() {
        int xDistance = city.getLocation().getX() - 180;
        int yDistance = city.getLocation().getY() - 70;
        return (int) (Math.sqrt(xDistance ^ 2 + yDistance ^ 2));
    }

    public int distanceToMonster(Monster monster, City city) {
        int xDistance = city.getLocation().getX() - monster.getLocation().getX();
        int yDistance = city.getLocation().getY() - monster.getLocation().getY();
        return (int) (Math.sqrt(xDistance ^ 2 + yDistance ^ 2));
    }
}