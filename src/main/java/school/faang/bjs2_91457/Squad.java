package school.faang.bjs2_91457;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    private final String name;
    private final List<Fighter> fighters;

    public int calculateSquadPower() {
        int totalPower = 0;

        for (Fighter fighter : fighters) {
            totalPower += fighter.getPower();
        }
        return totalPower;
    }
}
