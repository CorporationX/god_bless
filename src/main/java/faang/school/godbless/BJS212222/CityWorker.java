package faang.school.godbless.BJS212222;

import java.util.List;
import java.util.stream.Collectors;

public class CityWorker implements Runnable {
    @Override
    public void run() {

    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        monsters.stream()
                .collect(Collectors.toMap((key, value) ->
                        key -> ))
                .mapToInt(m -> Math.abs(m.getLocation().getX() - city.getLocation().getX())
                        + Math.abs(m.getLocation().getY() - city.getLocation().getY()))

    }
}
