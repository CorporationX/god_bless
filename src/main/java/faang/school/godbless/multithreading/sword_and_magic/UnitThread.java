package faang.school.godbless.multithreading.sword_and_magic;

import lombok.Getter;

@Getter
public class UnitThread extends Thread {
    private final Unit unit;
    private int unitPower;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }
}
