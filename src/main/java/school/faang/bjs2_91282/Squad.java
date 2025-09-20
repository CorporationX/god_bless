package school.faang.bjs2_91282;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Squad {
    private String unitType;
    private List<Unit> squadMembers = new ArrayList<>();

    public void addUnit(Unit unit) {
        squadMembers.add(unit);
    }

    public int calculateSquadPower() {
        return squadMembers.stream().mapToInt(Unit::getPower).sum();
    }
}