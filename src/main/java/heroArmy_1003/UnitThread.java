package heroArmy_1003;

import lombok.Getter;

public class UnitThread extends Thread {

    @Getter
    private int power;
    private final Unit unit;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}