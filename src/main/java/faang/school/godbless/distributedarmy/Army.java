package faang.school.godbless.distributedarmy;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units;

    public Army() {
        this.units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        return units.parallelStream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}