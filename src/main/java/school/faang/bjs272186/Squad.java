package school.faang.bjs272186;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Squad {
    private String squadName;
    private final List<Fighters> fighters;

    public int calculateSquadPower() {
        int totalPower = 0;
        for (Fighters squad : fighters) {
            totalPower += squad.getPower();
        }
        return totalPower;
    }
}