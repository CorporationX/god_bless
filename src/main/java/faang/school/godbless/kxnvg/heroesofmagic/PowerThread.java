package faang.school.godbless.kxnvg.heroesofmagic;

import lombok.Getter;

public class PowerThread extends Thread {

    private Unit unit;
    @Getter
    private int unitPower;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }
}
