package school.faang.bjs2_81042.divisions;

import lombok.AllArgsConstructor;
import school.faang.bjs2_81042.units.Unit;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private String name;
    private List<Unit> units;

    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}
