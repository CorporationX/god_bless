package school.faang.task_61152;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class Squad {
    private String name;
    private List<Unit> units;

    public int calculateSquadPower() {
        return units.stream().mapToInt(Unit::getPower).sum();
    }
}
