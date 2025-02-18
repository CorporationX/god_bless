package school.faang.task_61101;

import java.util.List;
import java.util.Objects;

public class Squad {
    private final List<Unit> units;

    public Squad(List<Unit> units) {
        validateUnits(units);
        this.units = units;
    }

    public int calculateTotalPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }

    private void validateUnits(List<Unit> units) {
        if (units == null) {
            throw new IllegalArgumentException("Unit list can't be null");
        }
        if (units.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Unit in list can't be null");
        }
    }
}
