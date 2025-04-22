package school.faang.bjs272508;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class Squad {
    private String name;
    private List<Unit> units;

    public int calculateSquadPower() {
        int totalPower = 0;
        for (Unit unit : units) {
            totalPower += unit.getPower();
        }
        return totalPower;
    }
}
