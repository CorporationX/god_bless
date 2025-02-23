package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Unit> units = new ArrayList<>();


    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
