package faang.school.godbless.ArmyHeroesMightAndMagic;

import lombok.Data;

@Data
public class UnitThread extends Thread{
    private Unit unit;
    private int powerUnit;

    public UnitThread(Unit unit, int powerUnit) {
        this.unit = unit;
        this.powerUnit = powerUnit;
    }
}
