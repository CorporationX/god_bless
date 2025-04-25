package school.faang.bjs272205;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {

    private String name;
    private final List<Unit> fighters;

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
