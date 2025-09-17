package school.faang.bjs2_91444;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Squad {
    private String squadName;
    private List<Unit> units;

    public static int calculateSquadPower(@NonNull Squad squad) {
        return squad.units.stream()
                .map(Unit::getPower)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
