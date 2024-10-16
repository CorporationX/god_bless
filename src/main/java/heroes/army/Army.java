package heroes.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> unitList = new ArrayList<>();
    List<Unit> archer  = new ArrayList<>();
    List<Unit> mag  = new ArrayList<>();
    List<Unit> swordman  = new ArrayList<>();

    public Army(List<Unit> unitList) {
        this.unitList = unitList;
    }

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }

    public Integer calculateTotalPower(List<Unit> unitList) throws InterruptedException{
        List<Thread> threadList = new ArrayList<>();
        List<PowerCalculator> powerCalculatorList = new ArrayList<>();
        int totalPower = 0;
        for (Unit unit : unitList) {
            if(Unit.)
        }
        return totalPower;
    }
}
