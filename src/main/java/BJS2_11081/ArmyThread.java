package BJS2_11081;

import lombok.Getter;

@Getter

public class ArmyThread extends Thread {
    private final Unit unit;
    private int unitPower;

    public ArmyThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }

}
