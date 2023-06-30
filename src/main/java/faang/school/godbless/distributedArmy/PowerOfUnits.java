package faang.school.godbless.distributedArmy;

import lombok.Data;

@Data
public class PowerOfUnits extends Thread {
    private Unit unit;
    private int unitPower;

    public PowerOfUnits(Unit unit) {
        this.unit = unit;
    }
}
