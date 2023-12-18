package faang.school.godbless.ArmyHeroesMightAndMagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();


    public int calculateTotalPower() {
        int final allPower;
        for (Unit unit : units) {
            new Thread(() ->{
                if(unit instanceof Archer)
                    allPower += unit.getPower();
            }

        }
        return allPower;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
