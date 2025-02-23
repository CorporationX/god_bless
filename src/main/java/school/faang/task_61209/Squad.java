package school.faang.task_61209;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    @NonNull
    private final List<Soldier> soldiers;

    public int calculateSquadPower() {
        return soldiers.stream()
                .mapToInt(Soldier::getPower)
                .sum();
    }
}
