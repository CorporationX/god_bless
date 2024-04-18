package faang.school.godbless.fingerpath;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Ближайшие монсты вблизи " + city.getName() + " - " + findNearestMonster());
        System.out.println("Время на убийство: " + getKillTime());
        System.out.println("Дистанция до города - " + getJourneyDistance());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return null;
    }

    public long getKillTime() {
        return 0;
    }

    public long getJourneyDistance() {
        return 0;
    }
}
