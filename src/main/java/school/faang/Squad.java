package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Squad {
    private String squadName;
    private List<Unit> units;

    public static int calculateSquadPower(List<Unit> units) {
        return units.stream()
                .map(Unit::getPower)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(522);
    }
}
