package faang.school.godbless.BJS2_11048;

import lombok.Getter;

public class PowerThread extends Thread {
    private Unit unit;

    private int power;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    public int getPower(){
        return unit.getPower();
    }

    @Override
    public void run() {
        power = getPower();
    }

}
