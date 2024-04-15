package faang.school.godbless.HerosAndMagicArmy;

import lombok.Getter;

@Getter
public class UnitThread extends Thread {
    private final Unit unit;
    private int power;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
