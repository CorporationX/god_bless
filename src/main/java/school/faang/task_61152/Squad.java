package school.faang.task_61152;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class Squad {
    private String nameSquad;
    private List<Unit> unit;

    public int calculateSquadPower() {
        return unit.stream().mapToInt(Unit::getPower).sum();
    }
}
