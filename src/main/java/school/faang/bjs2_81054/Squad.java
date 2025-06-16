package school.faang.bjs2_81054;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    private String nameSquad;
    private List<Unit> units;

    public int calculateSquadPower() {
        return units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
