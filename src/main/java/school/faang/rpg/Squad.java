package school.faang.rpg;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Squad {
    private final String name;
    private final List<Fighter> fighters;

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }
}
