package school.faang.distributedarmy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Squad {
    @Getter
    private String name;
    private List<Unit> units;

    public int calculateSquadPower() {
        return units
                .stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}