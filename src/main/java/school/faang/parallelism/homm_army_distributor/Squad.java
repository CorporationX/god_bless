package school.faang.parallelism.homm_army_distributor;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Squad {
    private final String name;
    private final List<Unit> unitList;

    public int calculateSquadPower() {
        return unitList.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
