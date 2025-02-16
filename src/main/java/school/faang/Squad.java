package school.faang;

import school.faang.units.Unit;

import java.util.List;

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
        if (units == null) {
            throw new IllegalArgumentException("List of units can't be null.");
        }
    }
}
