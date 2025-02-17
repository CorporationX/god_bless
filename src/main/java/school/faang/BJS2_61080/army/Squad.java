package school.faang.BJS2_61080.army;

import lombok.AllArgsConstructor;
import school.faang.BJS2_61080.units.Fighter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class Squad {
    private final List<Fighter> fighters;

    public int calculateSquadPower() {
        Objects.requireNonNull(fighters, "List<Fighter> can't be null");

        return fighters.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }
}
