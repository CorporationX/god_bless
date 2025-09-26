package school.faang.bjs2_91325;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private final String squadName;
    private final List<Unit> squad;

    public int calculateSquadPower() {
        return squad.stream()
                .map(Unit::getPower)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
