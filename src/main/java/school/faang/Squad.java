package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Squad {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit... units) {
        for (Unit unit:units)
        this.units.add(unit);
    }

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(Unit::getPower).sum();
    }
}
