package school.faang.magic_army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> armyUnits = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyUnits.add(unit);
    }
}
