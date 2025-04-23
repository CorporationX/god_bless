package school.faang.heroe;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Squad {

    private final String name;

    private final List<Unit> unitList;

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }

    public int calculateSquadPower() {
        return unitList.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
