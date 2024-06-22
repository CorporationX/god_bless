package faang.school.godbless.Set_the_Path;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
@Getter
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monster;

    @Override
    public void run() {
        System.out.println("I found a monster: " + findNearestMonster());
        System.out.println("I'm going to kill it: " + getKillTime());
        System.out.println("The Distance to the city: " + getJourneyDistance());
    }

    public Monster findNearestMonster() {

    }

    public long getKillTime() {

    }

    public long getJourneyDistance() {

    }

}
