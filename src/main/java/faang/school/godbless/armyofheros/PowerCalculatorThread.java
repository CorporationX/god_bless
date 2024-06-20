package faang.school.godbless.armyofheros;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PowerCalculatorThread extends Thread {
    private Unit unit;

    public int getPower() {
        return unit.getPower();
    }
}
