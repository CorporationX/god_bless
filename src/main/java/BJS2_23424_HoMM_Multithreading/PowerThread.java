package BJS2_23424_HoMM_Multithreading;

import lombok.Getter;

@Getter
public class PowerThread extends Thread {
    private final Unit unit;
    private int unitsPower;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitsPower = unit.getPower();
    }
}
