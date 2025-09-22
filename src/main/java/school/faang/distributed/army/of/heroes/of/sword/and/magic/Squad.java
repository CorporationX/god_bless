package school.faang.distributed.army.of.heroes.of.sword.and.magic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Squad {
    private String name;
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        return units.parallelStream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
