package school.faang.bjs2_91353;

import school.faang.bjs2_91353.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Unit> units = new ArrayList<>();

    public void addUnits(Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
