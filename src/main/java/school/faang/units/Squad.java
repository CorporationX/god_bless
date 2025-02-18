package school.faang.units;

import java.util.List;
import java.util.Objects;

public class Squad {
    private final List<Unit> units;

    public Squad(List<Unit> units) {
        validateUnits(units);
        this.units = units;
    }

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }

    private void validateUnits(List<Unit> units) {
        if (units == null || units.isEmpty()) {
            throw new IllegalArgumentException("List of units can't be null or empty.");
        }
        if (units.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Unit in list can't be null.");
        }
    }
}
