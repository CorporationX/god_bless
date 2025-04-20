package school.faang.bjs272167;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private final List<Unit> units;

    public int calculateSquadPower() {
        return units.stream()
                .reduce(0, (totalPower, unit) -> totalPower + unit.getPower(), Integer::sum);
    }
}
