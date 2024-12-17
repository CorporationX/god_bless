package school.faang.sprint3.bjs_47652;

import lombok.Getter;

public class UnitThread extends Thread {
    private final Unit unit;
    @Getter
    private int power;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
