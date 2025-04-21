package distributedHeroesArmy;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public static int calculateSquadPower(List<Unit> units) {
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
