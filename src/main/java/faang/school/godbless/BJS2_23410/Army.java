package faang.school.godbless.BJS2_23410;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Army {
    private List<Unit> armyList = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyList.add(unit);
    }

    public int calculateTotalPower() {
        return armyList.parallelStream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
