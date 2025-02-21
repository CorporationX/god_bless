package school.faang.task_61209;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    private static final int DEFAULT_SQUAD_POWER = 0;

    @NonNull
    private final List<Soldier> soldiers;

    public int calculateSquadPower() {
        return soldiers.stream()
                .reduce(DEFAULT_SQUAD_POWER,
                        (powerSum, soldier) -> powerSum + soldier.getPower(),
                        Integer::sum);
    }
}
