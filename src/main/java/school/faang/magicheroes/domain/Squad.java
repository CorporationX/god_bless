package school.faang.magicheroes.domain;

import lombok.Data;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 16.06.2025
 */
@Data
public class Squad {

    private final String name;
    private final List<Unit> units;

    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
