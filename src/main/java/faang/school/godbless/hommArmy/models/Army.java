package faang.school.godbless.hommArmy.models;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> army;

    public Army() {
        army = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        if (unit != null) {
            army.add(unit);
        }
    }

    public int calculateTotalPower() throws InterruptedException {
        /*return army.parallelStream()
                .mapToInt(Character::getPower)
                .sum();*/
        List<PowerUnit> powerUnits = new ArrayList<>();
        for (Unit unit : army) {
            powerUnits.add(new PowerUnit(unit));
        }

        for (PowerUnit powerUnit : powerUnits) {
            powerUnit.start();
            powerUnit.join();
        }

        return powerUnits.stream().mapToInt(PowerUnit::getPower).sum();
    }
}
