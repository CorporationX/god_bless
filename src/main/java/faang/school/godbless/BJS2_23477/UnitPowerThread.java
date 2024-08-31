package faang.school.godbless.BJS2_23477;

import lombok.Getter;

@Getter
public class UnitPowerThread extends Thread {

    private final Unit unit;
    private int result;

    public UnitPowerThread(Unit unit, int result) {
        this.unit = unit;
        this.result = result;
    }

    @Override
    public void run() {
        result += unit.getPower();
    }
}
