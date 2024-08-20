package faang.school.godbless.BJS223397;

import lombok.Getter;

@Getter
public class UnitThread extends Thread {
    private Unit unit;
    private int power;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
