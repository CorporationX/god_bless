package heroes.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> unitList = new ArrayList<>();

    public Army(List<Unit> unitList) {
        this.unitList = unitList;
    }

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }

    public Integer calculateTotalPower(List<Unit> unitList) {
        int totalPower = 0;
        for (Unit unit : unitList) {
            totalPower += unit.getPower();
        }
        return totalPower;
    }
}
