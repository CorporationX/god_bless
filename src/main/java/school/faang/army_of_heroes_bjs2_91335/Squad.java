package school.faang.army_of_heroes_bjs2_91335;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Squad {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public Integer calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}