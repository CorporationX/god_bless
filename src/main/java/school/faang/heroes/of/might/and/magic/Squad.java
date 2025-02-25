package school.faang.heroes.of.might.and.magic;

import java.util.ArrayList;
import java.util.List;

public class Squad {

    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}